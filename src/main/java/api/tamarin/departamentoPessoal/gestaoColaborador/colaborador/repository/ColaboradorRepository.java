package api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.repository;

import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, UUID> {
    List<Colaborador> findByStatusColaborador(StatusColaboradorENUM status);
}
