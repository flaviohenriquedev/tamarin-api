package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.repository;

import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilSistemaModuloRepository extends JpaRepository<PerfilSistemaModulo, UUID> {
    List<PerfilSistemaModulo> findByPerfilSistemaId(UUID perfilSistemaId);
}
