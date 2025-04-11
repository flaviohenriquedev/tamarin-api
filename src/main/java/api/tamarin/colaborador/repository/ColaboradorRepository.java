package api.tamarin.colaborador.repository;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin.colaborador.model.Colaborador;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ColaboradorRepository extends CRUDRepository<Colaborador, UUID> {
}
