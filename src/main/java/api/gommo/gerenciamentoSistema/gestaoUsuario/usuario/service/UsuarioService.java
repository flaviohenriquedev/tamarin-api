package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.service.EmpresaService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto.PerfilModuloDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.DadosAcessoDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService extends DefaultServiceImpl<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmpresaService empresaService;

    @Override
    protected DefaultRepository<Usuario, UUID> getRepository() {
        return usuarioRepository;
    }

    @Override
    protected DtoMapper<Usuario, UsuarioDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Usuario.class, UsuarioDTO.class);
    }

    public boolean possuiAcessoAEmpresa(UUID idUsuario, UUID idEmpresa) {
        return usuarioRepository.possuiAcessoAEmpresa(idUsuario, idEmpresa);
    }

    public boolean existePorEmail(String email) {
        return usuarioRepository.existsByEmail(email);
    }

    public void createUserAdmin(String email) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome("Admin");
        usuario.setEmail(email);
        usuario.setCpf("00000000000");
        usuario.setSenha(passwordEncoder.encode("g0mm0"));
        usuario.setUsuarioMaster(true);
        this.salvar(usuario);
    }

    @Override
    public List<UsuarioDTO> listar() {
        return getMapper().toDtoList(usuarioRepository.listarUsuarios(usuarioRepository.getEmpresaId()));
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO dto) {
        this.validacoes(dto);

        if (!dto.getPerfis().isEmpty()) {
            dto.getPerfis().forEach(usuarioPerfil -> {
                usuarioPerfil.setUsuario(dto);
                PerfilDTO perfil = perfilService.findById(usuarioPerfil.getPerfil().getId());
                usuarioPerfil.setPerfil(perfil);
            });
        }

        Usuario usuario = usuarioRepository.save(getMapper().toEntity(dto));
        return getMapper().toDto(usuario);
    }

    private void validacoes(UsuarioDTO dto) {
        boolean novoUsuario = dto.getId() == null;

        Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(dto.getEmail());

        if (novoUsuario && usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        if (!novoUsuario && usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(dto.getId())) {
            throw new IllegalArgumentException("E-mail já está em uso por outro usuário.");
        }

        if (novoUsuario) {
            String digitosCPF = dto.getCpf().substring(0, 5);
            dto.setSenha(passwordEncoder.encode(digitosCPF));
        }
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        UsuarioDTO usuarioDTO = getMapper()
                .toDto(usuarioRepository.findByEmail(email).orElse(new Usuario()));

        if (usuarioDTO.getUsuarioMaster()) {
            usuarioDTO.setDadosAcesso(this.getDadosAcessosAdmin());
        } else {
            // Se não tiver perfis, já retorna vazio
            if (usuarioDTO.getPerfis().isEmpty()) return usuarioDTO;

            // Map intermediário: (EmpresaId, SistemaENUM) → DadosAcessoDTO
            Map<String, DadosAcessoDTO> acessoMap = new HashMap<>();

            for (UsuarioPerfilDTO up : usuarioDTO.getPerfis()) {
                PerfilDTO perfil = up.getPerfil();
                var empresa = perfil.getEmpresaTenant();       // suposto EmpresaDTO
                var sistema = perfil.getSistema();             // SistemaENUM
                String key = empresa.getId().toString() + "|" + sistema.name();

                DadosAcessoDTO dados = acessoMap.computeIfAbsent(key, k -> DadosAcessoDTO.builder()
                        .empresa(empresa)
                        .sistemas(new ArrayList<>())
                        .build());

                // Encontra o sistema dentro do DadosAcessoDTO atual
                var sistemaDTO = dados.getSistemas().stream()
                        .filter(ds -> ds.getSistema() == sistema)
                        .findFirst()
                        .orElseGet(() -> {
                            var novo = DadosAcessoDTO.DadosAcessoSistemaDTO.builder()
                                    .sistema(sistema)
                                    .modulos(new ArrayList<>())
                                    .build();
                            dados.getSistemas().add(novo);
                            return novo;
                        });

                // Processa módulos do perfil
                for (PerfilModuloDTO pm : perfil.getPerfilModulos()) {
                    var modulo = pm.getModulo();
                    // acha ou cria módulo dentro do sistema
                    var modDTO = sistemaDTO.getModulos().stream()
                            .filter(m -> m.getModulo() == modulo)
                            .findFirst()
                            .orElseGet(() -> {
                                var novoMod = DadosAcessoDTO.DadosAcessoSistemaModuloDTO.builder()
                                        .modulo(modulo)
                                        .funcionalidades(new ArrayList<>())
                                        .build();
                                sistemaDTO.getModulos().add(novoMod);
                                return novoMod;
                            });

                    // Junta funcionalidades, evitando duplicata
                    for (var func : pm.getFuncionalidades()) {
                        if (!modDTO.getFuncionalidades().contains(func)) {
                            modDTO.getFuncionalidades().add(func);
                        }
                    }
                }
            }

            // Preenche no usuário
            usuarioDTO.setDadosAcesso(new ArrayList<>(acessoMap.values()));
        }

        return usuarioDTO;
    }

    private List<DadosAcessoDTO> getDadosAcessosAdmin() {
        List<EmpresaDTO> empresas = empresaService.listar();
        List<DadosAcessoDTO> dadosAcessosList = new ArrayList<>();
        // para cada empresa
        if (!empresas.isEmpty()) {
            empresas.forEach(empresa -> {
                DadosAcessoDTO dadosAcesso = new DadosAcessoDTO();
                dadosAcesso.setEmpresa(empresa);

                // cada sistema da empresa
                if (!empresa.getSistemas().isEmpty()) {
                    dadosAcesso.setSistemas(new ArrayList<>());
                    empresa.getSistemas().forEach(empresaSistema -> {
                        dadosAcesso.getSistemas().add(
                                DadosAcessoDTO.DadosAcessoSistemaDTO
                                        .builder()
                                        .sistema(empresaSistema.getKeySistema())
                                        .build()
                        );
                    });
                }
                dadosAcessosList.add(dadosAcesso);
            });
        }
        return dadosAcessosList;
    }
}