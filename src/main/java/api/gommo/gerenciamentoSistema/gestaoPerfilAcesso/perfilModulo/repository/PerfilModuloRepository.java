package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.model.PerfilModulo;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerfilModuloRepository extends DefaultRepository<PerfilModulo, UUID> {
}
