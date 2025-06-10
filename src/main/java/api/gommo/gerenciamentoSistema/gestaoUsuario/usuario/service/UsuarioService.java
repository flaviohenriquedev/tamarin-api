package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
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
        return getMapper().toDto(usuarioRepository.findByEmail(email).orElse(new Usuario()));
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