package com.br.tamarin.usuario.service;

import com.br.tamarin.root.repository.CRUDRepository;
import com.br.tamarin.root.service.impl.ServiceImpl;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.repository.UsuarioRepository;
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
