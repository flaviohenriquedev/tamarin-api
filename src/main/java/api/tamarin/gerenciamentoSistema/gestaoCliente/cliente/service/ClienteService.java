package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.model.Cliente;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.repository.ClienteRepository;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.service.ClienteSistemaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService extends DefaultServiceImpl<Cliente, ClienteDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ClienteSistemaService clienteSistemaService;

    @Override
    protected JpaRepository<Cliente, UUID> getRepository() {
        return clienteRepository;
    }

    @Override
    protected DtoMapper<Cliente, ClienteDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, Cliente.class, ClienteDTO.class);
    }

    @Override
    public ClienteDTO salvar(ClienteDTO cliente) {
        ClienteDTO clienteSalvo = super.salvar(cliente);
        if (!cliente.getSistemas().isEmpty()) {
            cliente.getSistemas().forEach(sistema -> {
                sistema.setCliente(clienteSalvo);
                clienteSistemaService.salvar(sistema);
            });
        }
        return clienteSalvo;
    }
}
