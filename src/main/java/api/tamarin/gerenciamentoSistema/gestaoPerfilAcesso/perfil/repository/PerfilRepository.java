package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository;

import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, UUID> {
    @EntityGraph(attributePaths = "sistemas")
    List<Perfil> findByClienteId(UUID clienteId);

    @EntityGraph(attributePaths = "sistemas")
    List<Perfil> findBySistemasClienteSistemaId(UUID sistemasClienteSistemaId);
}
