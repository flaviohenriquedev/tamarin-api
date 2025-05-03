package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.repository.UsuarioPerfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioPefilService extends DefaultServiceImpl<UsuarioPerfil> {

    @Autowired
    private UsuarioPerfilRepository repository;

    @Override
    protected JpaRepository<UsuarioPerfil, UUID> getRepository() {
        return repository;
    }
}