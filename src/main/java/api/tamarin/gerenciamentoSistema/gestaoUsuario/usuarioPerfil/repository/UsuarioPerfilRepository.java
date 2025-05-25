package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.repository;

import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioPerfilRepository extends JpaRepository<UsuarioPerfil, UUID> {
}
