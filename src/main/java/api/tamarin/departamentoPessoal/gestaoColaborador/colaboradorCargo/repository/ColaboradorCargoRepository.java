package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.repository;

import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorCargoRepository extends JpaRepository<ColaboradorCargo, UUID> {
}
