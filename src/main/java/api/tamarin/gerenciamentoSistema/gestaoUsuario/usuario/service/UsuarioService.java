package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService extends DefaultServiceImpl<Usuario, UsuarioDTO> {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    protected JpaRepository<Usuario, UUID> getPerfilRepository() {
        return repository;
    }

    @Override
    protected DtoMapper<Usuario, UsuarioDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Usuario.class, UsuarioDTO.class);
    }

    public UsuarioDTO findByEmail(String email) {
        return getMapper().toDto(repository.findByEmail(email).orElse(new Usuario()));
    }

    @Override
    public UsuarioDTO salvar(UsuarioDTO dto) {
        if (!repository.existsByEmail(dto.getEmail())) {
            if (!dto.getClientes().isEmpty()) {
                dto.getClientes().forEach(cliente -> cliente.setUsuario(dto));
            }
            Usuario entity = getMapper().toEntity(dto);
            String digitosCPF = entity.getCpf().substring(0, 5);
            entity.setSenha(passwordEncoder.encode(digitosCPF));

            Usuario saved = getPerfilRepository().save(entity);
            return getMapper().toDto(saved);
        }
        return new UsuarioDTO();
    }

    public UsuarioDTO getUser(String email) {
        UsuarioDTO usuario = this.findByEmail(email);



        return usuario;
    }
}