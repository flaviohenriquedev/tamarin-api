package api.tamarin.departamento.service;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin._root.comum.service.impl.ServiceImpl;
import api.tamarin.departamento.model.Departamento;
import api.tamarin.departamento.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DepartamentoService extends ServiceImpl<Departamento> {

    @Autowired
    private DepartamentoRepository repository;

    @Override
    protected CRUDRepository<Departamento, UUID> getRepository() {
        return repository;
    }
}
