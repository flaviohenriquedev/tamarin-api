package api.gommo.departamentoPessoal.gestao.ferias.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestao.ferias.model.ColaboradorFerias;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorFeriasRepository extends DefaultRepository<ColaboradorFerias, UUID> {
}
