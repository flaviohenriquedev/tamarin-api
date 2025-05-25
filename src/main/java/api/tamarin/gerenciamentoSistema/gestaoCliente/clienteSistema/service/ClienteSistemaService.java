package api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.service;

import api.tamarin._root.comum.service.DtoMapper;
import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin._root.comum.service.impl.DtoMapperImpl;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.model.ClienteSistema;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.repository.ClienteSistemaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteSistemaService extends DefaultServiceImpl<ClienteSistema, ClienteSistemaDTO> {

    @Autowired
    private ClienteSistemaRepository clienteSistemaRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    protected JpaRepository<ClienteSistema, UUID> getRepository() {
        return clienteSistemaRepository;
    }

    @Override
    protected DtoMapper<ClienteSistema, ClienteSistemaDTO> getMapper() {
        return new DtoMapperImpl<>(modelMapper, ClienteSistema.class, ClienteSistemaDTO.class);
    }

    public List<ClienteSistemaDTO> listarPorIdCliente(UUID idCliente) {
        return getMapper().toDtoList(clienteSistemaRepository.findByClienteId(idCliente));
    }
}
