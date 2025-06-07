package api.gommo.gerenciamentoSistema.gestaoCliente.cliente.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends DefaultController<ClienteDTO> {

    @Autowired
    private ClienteService clienteService;

    @Override
    protected DefaultService<ClienteDTO> getService() {
        return clienteService;
    }

    @PostMapping("/salvar-em-massa")
    public void salvarEmMassa(@RequestBody List<ClienteDTO> lista) {
        clienteService.salvarEmMassa(lista);
    }
}
