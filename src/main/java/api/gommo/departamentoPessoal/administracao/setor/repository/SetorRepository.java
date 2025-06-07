package api.gommo.departamentoPessoal.administracao.setor.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.administracao.setor.model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SetorRepository extends DefaultRepository<Setor, UUID> {
}
