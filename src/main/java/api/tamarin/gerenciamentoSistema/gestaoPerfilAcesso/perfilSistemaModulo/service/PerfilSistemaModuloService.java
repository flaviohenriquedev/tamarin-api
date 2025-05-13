package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.repository.PerfilSistemaModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilSistemaModuloService extends DefaultServiceImpl<PerfilSistemaModulo> {

    @Autowired
    private PerfilSistemaModuloRepository perfilSistemaModuloRepository;

    @Override
    protected JpaRepository<PerfilSistemaModulo, UUID> getRepository() {
        return perfilSistemaModuloRepository;
    }
}
