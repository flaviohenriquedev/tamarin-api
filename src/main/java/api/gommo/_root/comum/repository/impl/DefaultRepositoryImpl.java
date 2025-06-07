package api.gommo._root.comum.repository.impl;

import api.gommo._root._infra.service.ClienteContextService;
import api.gommo._root.comum.model.EntidadeCliente;
import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import java.util.List;
import java.util.UUID;

public class DefaultRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements DefaultRepository<T, ID> {

    private final EntityManager entityManager;

    // Aqui vamos guardar manualmente o serviço
    @Setter
    private static ClienteContextService clienteContextService;

    public DefaultRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
                                 EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public <S extends T> S save(S entity) {
        setClienteIfApplicable(entity);
        return super.save(entity);
    }

    @Override
    @Transactional
    public <S extends T> List<S> saveAll(Iterable<S> entities) {
        entities.forEach(this::setClienteIfApplicable);
        return super.saveAll(entities);
    }

    private void setClienteIfApplicable(Object entity) {
        if (entity instanceof EntidadeCliente entidadeCliente && clienteContextService != null) {
            String clienteIdStr = clienteContextService.getClienteId();
            if (clienteIdStr != null) {
                UUID clienteId = UUID.fromString(clienteIdStr);
                Cliente cliente = new Cliente();
                cliente.setId(clienteId);
                entidadeCliente.setCliente(cliente);
            }
        }
    }
}
