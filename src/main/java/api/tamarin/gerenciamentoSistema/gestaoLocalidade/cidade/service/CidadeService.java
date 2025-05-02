package api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CidadeService extends DefaultServiceImpl<Cidade> {

    @Autowired
    private CidadeRepository repository;

    @Override
    protected JpaRepository<Cidade, UUID> getRepository() {
        return repository;
    }
}
