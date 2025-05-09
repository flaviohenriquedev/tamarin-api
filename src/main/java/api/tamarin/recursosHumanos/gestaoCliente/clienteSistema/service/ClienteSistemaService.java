package api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model.ClienteSistema;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.repository.ClienteSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteSistemaService extends DefaultServiceImpl<ClienteSistema> {

    @Autowired
    ClienteSistemaRepository clienteSistemaRepository;

    @Override
    protected JpaRepository<ClienteSistema, UUID> getRepository() {
        return clienteSistemaRepository;
    }
}
