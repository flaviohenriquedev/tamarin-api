package api.tamarin.recursosHumanos.gestaoDepartamento.departamento.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.recursosHumanos.gestaoDepartamento.departamento.model.Departamento;
import api.tamarin.recursosHumanos.gestaoDepartamento.departamento.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartamentoService extends DefaultServiceImpl<Departamento> {

    @Autowired
    private DepartamentoRepository repository;

    @Override
    protected JpaRepository<Departamento, UUID> getRepository() {
        return repository;
    }
}
