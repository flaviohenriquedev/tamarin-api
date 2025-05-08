package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.repository;

import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model.UsuarioClienteSistemaPerfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioClienteSistemaPerfilRepository extends JpaRepository<UsuarioClienteSistemaPerfil, UUID> {
}
