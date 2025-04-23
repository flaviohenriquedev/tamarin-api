package api.tamarin.dominio.pais.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.dominio.pais.model.Pais;
import api.tamarin.dominio.pais.repository.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaisService extends DefaultServiceImpl<Pais> {

    @Autowired
    private PaisRepository repository;

    @Override
    protected JpaRepository<Pais, UUID> getRepository() {
        return repository;
    }
}
