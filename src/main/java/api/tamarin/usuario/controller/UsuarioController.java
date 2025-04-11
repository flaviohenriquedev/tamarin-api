package api.tamarin.usuario.controller;

import api.tamarin._root.comum.controller.CRUDController;
import api.tamarin._root.comum.service.Service;
import api.tamarin.usuario.model.Usuario;
import api.tamarin.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends CRUDController<Usuario> {

    @Autowired
    private UsuarioService service;

    @Override
    protected Service<Usuario> getService() {
        return service;
    }
}
