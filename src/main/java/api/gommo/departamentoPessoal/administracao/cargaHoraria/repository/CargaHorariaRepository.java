package api.gommo.departamentoPessoal.administracao.cargaHoraria.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.model.CargaHoraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargaHorariaRepository extends DefaultRepository<CargaHoraria, UUID> {
}
