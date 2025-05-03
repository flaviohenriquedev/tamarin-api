package api.tamarin.recursosHumanos.gestaoCliente.cliente.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends DefaultController<Cliente> {

    @Autowired
    private ClienteService clienteService;

    @Override
    protected DefaultService<Cliente> getService() {
        return clienteService;
    }
}
