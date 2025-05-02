package api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.repository;

import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, UUID> {
}
