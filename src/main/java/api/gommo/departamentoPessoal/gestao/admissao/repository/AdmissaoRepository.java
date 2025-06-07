package api.gommo.departamentoPessoal.gestao.admissao.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestao.admissao.model.Admissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdmissaoRepository extends DefaultRepository<Admissao, UUID> {
}
