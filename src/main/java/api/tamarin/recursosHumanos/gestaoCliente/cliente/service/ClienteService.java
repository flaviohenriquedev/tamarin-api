package api.tamarin.recursosHumanos.gestaoCliente.cliente.service;

import api.tamarin._root.comum.useCase.DtoConverter;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.repository.ClienteRepository;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.service.ClienteSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService extends DefaultServiceImpl<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteSistemaService clienteSistemaService;

    @Autowired
    private DtoConverter dtoConverter;

    @Override
    protected JpaRepository<Cliente, UUID> getRepository() {
        return clienteRepository;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        clienteRepository.save(cliente);
        if (!cliente.getSistemas().isEmpty()) {
            cliente.getSistemas().forEach(sistema -> {
                sistema.setCliente(cliente);
                clienteSistemaService.salvar(sistema);
            });
        }
        return cliente;
    }
}
