package api.tamarin.colaborador.service;

import api.tamarin._root.comum.repository.CRUDRepository;
import api.tamarin._root.comum.service.impl.ServiceImpl;
import api.tamarin.colaborador.model.Colaborador;
import api.tamarin.colaborador.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorService extends ServiceImpl<Colaborador> {

    @Autowired
    private ColaboradorRepository repository;

    @Override
    protected CRUDRepository<Colaborador, UUID> getRepository() {
        return repository;
    }
}
