package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorEnderecoRepository extends DefaultRepository<ColaboradorEndereco, UUID> {
}
