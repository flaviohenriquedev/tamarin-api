package api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.service;

import api.gommo._root.comum.service.DtoMapper;
import api.gommo._root.comum.service.impl.DefaultServiceImpl;
import api.gommo._root.comum.service.impl.DtoMapperImpl;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.repository.UsuarioPerfilRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioPerfilService extends DefaultServiceImpl<UsuarioPerfil, UsuarioPerfilDTO> {

    @Autowired
    private UsuarioPerfilRepository usuarioPerfilRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<UsuarioPerfil, UUID> getRepository() {
        return usuarioPerfilRepository;
    }

    @Override
    protected DtoMapper<UsuarioPerfil, UsuarioPerfilDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, UsuarioPerfil.class, UsuarioPerfilDTO.class);
    }
}
