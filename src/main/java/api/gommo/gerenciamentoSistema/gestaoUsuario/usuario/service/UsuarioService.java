package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.service.EmpresaService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

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

    public boolean possuiAcessoAoCliente(UUID idUsuario, UUID idCliente) {
        return usuarioRepository.possuiAcessoAoCliente(idUsuario, idCliente);
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

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        UsuarioDTO usuarioDTO = getMapper().toDto(usuarioRepository.findByEmail(email).orElse(new Usuario()));

        if (!usuarioDTO.getPerfis().isEmpty()) {
            usuarioDTO.getPerfis().stream().map(UsuarioPerfilDTO::getPerfil).toList()
                    .forEach(perfil -> {
                        EmpresaDTO empresaDTO = empresaService.buscarPorId(perfil.getEmpresaTenant().getId());
                        usuarioDTO.getEmpresas().add(empresaDTO);
                    });
        }

        return usuarioDTO;
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


    public void validacoes(UsuarioDTO dto) {
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
}