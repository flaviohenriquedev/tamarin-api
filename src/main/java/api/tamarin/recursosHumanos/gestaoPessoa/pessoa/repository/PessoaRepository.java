package api.tamarin.recursosHumanos.gestaoPessoa.pessoa.repository;

import api.tamarin.recursosHumanos.gestaoPessoa.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, UUID> {
}
