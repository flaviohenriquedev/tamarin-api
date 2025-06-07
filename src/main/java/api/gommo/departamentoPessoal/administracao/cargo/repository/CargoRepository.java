package api.gommo.departamentoPessoal.administracao.cargo.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.administracao.cargo.model.Cargo;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargoRepository extends DefaultRepository<Cargo, UUID> {
}
