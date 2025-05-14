package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.repository;

import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
}
