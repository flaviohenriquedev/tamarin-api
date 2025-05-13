package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.service.PerfilSistemaModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PerfilService extends DefaultServiceImpl<Perfil> {

    @Autowired
    private PerfilRepository perfilRepository;

    @Autowired
    private PerfilSistemaService perfilSistemaService;

    @Autowired
    private PerfilSistemaModuloService perfilSistemaModuloService;

    @Override
    protected JpaRepository<Perfil, UUID> getRepository() {
        return perfilRepository;
    }

    @Override
    public Perfil salvar(Perfil perfil) {
        perfilRepository.save(perfil);
        if (!perfil.getSistemas().isEmpty()) {
            perfil.getSistemas().forEach(perfilSistema -> {
                perfilSistema.setPerfil(perfil);
                perfilSistemaService.salvar(perfilSistema);
                if (!perfilSistema.getRotas().isEmpty()) {
                    perfilSistema.getRotas().forEach(modulo -> {
                        modulo.setPerfilSistema(perfilSistema);
                        perfilSistemaModuloService.salvar(modulo);
                    });
                }
            });
        }

        return perfil;
    }
}
