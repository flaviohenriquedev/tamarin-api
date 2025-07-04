package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository;

import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto.PerfilModuloDTO;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PerfilRepository extends DefaultRepository<Perfil, UUID> {
    List<Perfil> getBySistema(SistemaENUM sistema);
}
