package api.tamarin.departamentoPessoal.administracao.tipoContrato.repository;

import api.tamarin.departamentoPessoal.administracao.tipoContrato.model.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoContratoRepository extends JpaRepository<TipoContrato, UUID> {
}
