package api.tamarin.dominio.estado.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.dominio.estado.model.Estado;
import api.tamarin.dominio.estado.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EstadoService extends DefaultServiceImpl<Estado> {

    @Autowired
    private EstadoRepository repository;

    @Override
    protected JpaRepository<Estado, UUID> getRepository() {
        return repository;
    }
}
