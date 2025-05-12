package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.repository.PerfilSistemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilSistemaService extends DefaultServiceImpl<PerfilSistema> {

    @Autowired
    private PerfilSistemaRepository perfilSistemaRepository;

    @Override
    protected JpaRepository<PerfilSistema, UUID> getRepository() {
        return perfilSistemaRepository;
    }
}
