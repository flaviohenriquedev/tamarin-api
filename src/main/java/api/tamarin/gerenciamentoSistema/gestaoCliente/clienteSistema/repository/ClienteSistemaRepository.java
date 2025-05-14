package api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.repository;

import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.model.ClienteSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteSistemaRepository extends JpaRepository<ClienteSistema, UUID> {
}
