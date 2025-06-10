package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilSistemaRepository extends DefaultRepository<PerfilSistema, UUID> {
    @EntityGraph(attributePaths = "rotas")
    List<PerfilSistema> findByPerfilId(UUID perfilId);
}
