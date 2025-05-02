package api.tamarin.recursosHumanos.gestaoDepartamento.departamento.repository;

import api.tamarin.recursosHumanos.gestaoDepartamento.departamento.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DepartamentoRepository extends JpaRepository<Departamento, UUID> {
}
