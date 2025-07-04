package api.gommo.departamentoPessoal.gestao.afastamento.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestao.afastamento.model.ColaboradorAfastamento;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorAfastamentoRepository extends DefaultRepository<ColaboradorAfastamento, UUID> {
}
