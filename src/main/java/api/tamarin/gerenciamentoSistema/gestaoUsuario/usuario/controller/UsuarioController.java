package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioRegister;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends DefaultController<Usuario> {

    @Autowired
    private UsuarioService service;

    @Override
    protected DefaultService<Usuario> getService() {
        return service;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsuarioRegister usuarioRegister) {
        return service.register(usuarioRegister);
    }
}
