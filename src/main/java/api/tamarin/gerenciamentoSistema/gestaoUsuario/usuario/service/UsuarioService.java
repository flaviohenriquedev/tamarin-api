package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService extends DefaultServiceImpl<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PerfilSistemaService perfilSistemaService;

    @Override
    protected JpaRepository<Usuario, UUID> getPerfilRepository() {
        return repository;
    }

    @Override
    protected DtoMapper<Usuario, UsuarioDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Usuario.class, UsuarioDTO.class);
    }

    public UsuarioDTO buscarUsuarioPorEmail(String email) {
        return getMapper().toDto(repository.findByEmail(email).orElse(new Usuario()));
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO dto) {

        boolean novoUsuario = dto.getId() == null;

        Optional<Usuario> usuarioExistente = repository.findByEmail(dto.getEmail());

        if (novoUsuario && usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("E-mail já cadastrado.");
        }

        if (!novoUsuario && usuarioExistente.isPresent() && !usuarioExistente.get().getId().equals(dto.getId())) {
            throw new IllegalArgumentException("E-mail já está em uso por outro usuário.");
        }

        Usuario entity = getMapper().toEntity(dto);

        if (novoUsuario) {
            String digitosCPF = entity.getCpf().substring(0, 5);
            entity.setSenha(passwordEncoder.encode(digitosCPF));
        }

        Usuario saved = getPerfilRepository().save(entity);
        return getMapper().toDto(saved);
    }
}