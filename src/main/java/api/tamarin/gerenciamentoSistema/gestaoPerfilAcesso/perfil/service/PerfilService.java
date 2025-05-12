package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service;

import api.tamarin._root.comum.service.impl.DefaultServiceImpl;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.repository.PerfilRepository;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
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
            });
        }

        return perfil;
    }
}
