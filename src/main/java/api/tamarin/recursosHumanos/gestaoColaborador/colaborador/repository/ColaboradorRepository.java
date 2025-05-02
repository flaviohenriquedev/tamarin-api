package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.repository;

import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {
}
