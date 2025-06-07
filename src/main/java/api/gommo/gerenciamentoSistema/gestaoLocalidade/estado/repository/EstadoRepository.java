package api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EstadoRepository extends DefaultRepository<Estado, UUID> {
}
