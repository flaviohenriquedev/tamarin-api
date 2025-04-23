package api.tamarin.gestaoColaborador.colaborador.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gestaoColaborador.colaborador.model.Colaborador;
import api.tamarin.gestaoColaborador.colaborador.repository.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ColaboradorService extends DefaultServiceImpl<Colaborador> {

    @Autowired
    private ColaboradorRepository repository;

    @Override
    protected JpaRepository<Colaborador, UUID> getRepository() {
        return repository;
    }
}
