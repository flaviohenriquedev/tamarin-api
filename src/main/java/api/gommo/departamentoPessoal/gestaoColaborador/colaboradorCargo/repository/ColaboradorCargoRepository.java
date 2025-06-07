package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorCargoRepository extends DefaultRepository<ColaboradorCargo, UUID> {
}
