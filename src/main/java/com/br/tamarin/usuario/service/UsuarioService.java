package com.br.tamarin.usuario.service;

import com.br.tamarin.root.crud.Crud;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService extends Crud<Usuario> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void cadastrar(Usuario usuario) {
        onExecuteService(() -> usuarioRepository.save(usuario));
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
