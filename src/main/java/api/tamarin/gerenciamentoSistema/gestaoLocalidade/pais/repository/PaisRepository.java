package api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.repository;

import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaisRepository extends JpaRepository<Pais, UUID> {
}
