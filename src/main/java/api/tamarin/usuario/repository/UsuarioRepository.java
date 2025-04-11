package api.tamarin.usuario.repository;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin.usuario.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends CRUDRepository<Usuario, UUID> {
    Optional<Usuario> findByEmail(String login);

    boolean existsByEmail(String email);
}
