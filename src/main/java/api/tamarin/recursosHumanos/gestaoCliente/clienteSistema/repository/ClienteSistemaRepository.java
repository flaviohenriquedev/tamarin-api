package api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.repository;

import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model.ClienteSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteSistemaRepository extends JpaRepository<ClienteSistema, UUID> {
}
