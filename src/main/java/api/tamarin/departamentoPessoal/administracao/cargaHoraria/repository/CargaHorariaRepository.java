package api.tamarin.departamentoPessoal.administracao.cargaHoraria.repository;

import api.tamarin.departamentoPessoal.administracao.cargaHoraria.model.CargaHoraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargaHorariaRepository extends JpaRepository<CargaHoraria, UUID> {
}
