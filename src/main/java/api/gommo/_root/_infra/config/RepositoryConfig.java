package api.gommo._root._infra.config;

import api.gommo._root._infra.service.ClienteContextService;
import api.gommo._root.comum.repository.impl.DefaultRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Autowired
    public void injectClienteContextService(ClienteContextService clienteContextService) {
        DefaultRepositoryImpl.setClienteContextService(clienteContextService);
    }
}
