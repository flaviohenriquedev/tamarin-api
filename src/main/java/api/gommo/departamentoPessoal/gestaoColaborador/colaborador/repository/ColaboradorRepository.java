package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ColaboradorRepository extends DefaultRepository<Colaborador, UUID> {
    List<Colaborador> findByStatusColaborador(StatusColaboradorENUM status);
}
