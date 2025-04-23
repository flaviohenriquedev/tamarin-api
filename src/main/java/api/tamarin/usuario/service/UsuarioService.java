package api.tamarin.usuario.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.usuario.model.Usuario;
import api.tamarin.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService extends DefaultServiceImpl<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected JpaRepository<Usuario, UUID> getRepository() {
        return repository;
    }
}