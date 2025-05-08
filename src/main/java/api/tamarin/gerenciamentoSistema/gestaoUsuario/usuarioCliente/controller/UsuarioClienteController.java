package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.service.UsuarioClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario-cliente")
public class UsuarioClienteController extends DefaultController<UsuarioCliente> {

    @Autowired
    UsuarioClienteService usuarioClienteService;

    @Override
    protected DefaultService<UsuarioCliente> getService() {
        return usuarioClienteService;
    }
}
