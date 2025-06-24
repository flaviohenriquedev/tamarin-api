package api.gommo.departamentoPessoal.gestao.desligamento.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestao.desligamento.model.ColaboradorDesligamento;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorDesligamentoRepository extends DefaultRepository<ColaboradorDesligamento, UUID> {
}
