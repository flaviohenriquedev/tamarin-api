package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.repository;

import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PerfilSistemaRepository extends JpaRepository<PerfilSistema, UUID> {
}
