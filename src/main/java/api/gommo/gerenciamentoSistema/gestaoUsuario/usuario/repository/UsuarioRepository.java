package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends DefaultRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String login);

    boolean existsByEmail(String email);

    @Query("""
                select count(up) > 0
                from UsuarioPerfil up
                where up.usuario.id = :idUsuario
                  and up.perfil.empresaTenant.id = :idCliente
            """)
    boolean possuiAcessoAoCliente(UUID idUsuario, UUID idCliente);
}
