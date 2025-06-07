package api.gommo.gerenciamentoSistema.gestaoCliente.clienteSistema.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoCliente.clienteSistema.model.ClienteSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteSistemaRepository extends DefaultRepository<ClienteSistema, UUID> {
    List<ClienteSistema> findByClienteId(UUID clienteId);
}
