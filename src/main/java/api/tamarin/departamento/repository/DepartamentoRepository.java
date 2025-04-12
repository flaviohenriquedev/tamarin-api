package api.tamarin.departamento.repository;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin.departamento.model.Departamento;

import java.util.UUID;

public interface DepartamentoRepository extends CRUDRepository<Departamento, UUID> {
}
