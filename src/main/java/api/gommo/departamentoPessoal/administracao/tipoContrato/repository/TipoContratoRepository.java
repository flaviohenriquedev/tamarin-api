package api.gommo.departamentoPessoal.administracao.tipoContrato.repository;

import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo.departamentoPessoal.administracao.tipoContrato.model.TipoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TipoContratoRepository extends DefaultRepository<TipoContrato, UUID> {
}
