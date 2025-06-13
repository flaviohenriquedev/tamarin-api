package api.gommo._root.comum.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface DefaultRepository<T, ID> extends JpaRepository<T, ID> {
    UUID getEmpresaId();
}