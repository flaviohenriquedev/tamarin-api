package api.tamarin.usuario.service;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin._root.comum.service.impl.ServiceImpl;
import api.tamarin.usuario.model.Usuario;
import api.tamarin.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UsuarioService extends ServiceImpl<Usuario> {

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected CRUDRepository<Usuario, UUID> getRepository() {
        return repository;
    }
}