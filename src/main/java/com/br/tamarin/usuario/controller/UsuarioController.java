package com.br.tamarin.usuario.controller;

import com.br.tamarin.root.controller.CRUDController;
import com.br.tamarin.root.service.Service;
import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController extends CRUDController<Usuario, UUID> {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    protected Service<Usuario> getService() {
        return usuarioService;
    }
}
