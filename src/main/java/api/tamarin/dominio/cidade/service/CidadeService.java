package api.tamarin.dominio.cidade.service;

import api.tamarin._root.comum.service.impl.ServiceImpl;
import api.tamarin.dominio.cidade.model.Cidade;
import api.tamarin.dominio.cidade.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CidadeService extends ServiceImpl<Cidade> {

    @Autowired
    private CidadeRepository repository;

    @Override
    protected JpaRepository<Cidade, UUID> getRepository() {
        return repository;
    }
}
