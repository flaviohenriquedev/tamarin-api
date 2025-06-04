package api.tamarin.departamentoPessoal.administracao.cargo.repository;

import api.tamarin.departamentoPessoal.administracao.cargo.model.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, UUID> {
}
