package com.br.tamarin.usuario.controller;

import com.br.tamarin.usuario.entity.Usuario;
import com.br.tamarin.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @PostMapping
    public void cadastrar(@RequestBody Usuario usuario) {
        usuarioService.cadastrar(usuario);
    }
}
