package api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioPerfilRepository extends DefaultRepository<UsuarioPerfil, UUID> {
}
