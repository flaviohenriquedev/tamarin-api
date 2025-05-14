package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteController extends DefaultController<ClienteDTO> {

    @Autowired
    private ClienteService clienteService;

    @Override
    protected DefaultService<ClienteDTO> getService() {
        return clienteService;
    }
}
