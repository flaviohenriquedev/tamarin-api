package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilSistemaModuloRepository extends DefaultRepository<PerfilSistemaModulo, UUID> {
    List<PerfilSistemaModulo> findByPerfilSistemaId(UUID perfilSistemaId);
}
