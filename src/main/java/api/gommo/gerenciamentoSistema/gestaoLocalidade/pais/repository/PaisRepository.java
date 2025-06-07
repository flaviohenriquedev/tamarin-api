package api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends DefaultRepository<Pais, UUID> {
}
