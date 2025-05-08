package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.service.UsuarioClienteSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario-cliente-sistema")
public class UsuarioClienteSistemaController extends DefaultController<UsuarioClienteSistema> {

    @Autowired
    UsuarioClienteSistemaService usuarioClienteSistemaService;

    @Override
    protected DefaultService<UsuarioClienteSistema> getService() {
        return usuarioClienteSistemaService;
    }
}
