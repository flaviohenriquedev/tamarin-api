package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.repository;

import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioClienteSistemaRepository extends JpaRepository<UsuarioClienteSistema, UUID> {
}
