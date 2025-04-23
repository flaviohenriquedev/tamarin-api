package api.tamarin.pessoa.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.pessoa.model.Pessoa;
import api.tamarin.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PessoaService extends DefaultServiceImpl<Pessoa> {

    @Autowired
    private PessoaRepository repository;

    @Override
    protected JpaRepository<Pessoa, UUID> getRepository() {
        return repository;
    }
}
