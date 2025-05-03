package api.tamarin.recursosHumanos.gestaoCliente.cliente.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService extends DefaultServiceImpl<Cliente> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    protected JpaRepository<Cliente, UUID> getRepository() {
        return clienteRepository;
    }
}
