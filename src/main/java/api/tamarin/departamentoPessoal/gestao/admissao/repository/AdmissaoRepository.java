package api.tamarin.departamentoPessoal.gestao.admissao.repository;

import api.tamarin.departamentoPessoal.gestao.admissao.model.Admissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdmissaoRepository extends JpaRepository<Admissao, UUID> {
}
