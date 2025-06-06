package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
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
    private UsuarioRepository repository;

    @Autowired
    private PerfilService perfilService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected JpaRepository<Usuario, UUID> getRepository() {
        return repository;
    }

    @Override
    protected DtoMapper<Usuario, UsuarioDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Usuario.class, UsuarioDTO.class);
    }

    public boolean existePorEmail(String email) {
        return repository.existsByEmail("admin@admin");
    }

    public void createUserAdmin(String email) {
        UsuarioDTO usuario = new UsuarioDTO();
        usuario.setNome("Admin");
        usuario.setEmail(email);
        usuario.setSenha(passwordEncoder.encode("g0mm0"));
        usuario.setUsuarioMaster(true);
        this.salvar(usuario);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return getMapper().toDto(repository.findByEmail(email).orElse(new Usuario()));
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

        Usuario usuario = repository.save(getMapper().toEntity(dto));
        return getMapper().toDto(usuario);
    }


    public void validacoes(UsuarioDTO dto) {
        boolean novoUsuario = dto.getId() == null;

        Optional<Usuario> usuarioExistente = repository.findByEmail(dto.getEmail());

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