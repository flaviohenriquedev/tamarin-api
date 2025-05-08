package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.repository;

import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, UUID> {
}
