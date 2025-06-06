package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.repository;

import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorEnderecoRepository extends JpaRepository<ColaboradorEndereco, UUID> {
}
