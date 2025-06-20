package api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CidadeRepository extends DefaultRepository<Cidade, UUID> {
    List<Cidade> findByNomeStartingWithIgnoreCase(String nome);
}
