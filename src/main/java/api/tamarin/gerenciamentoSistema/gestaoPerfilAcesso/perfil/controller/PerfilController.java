package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil")
public class PerfilController extends DefaultController<Perfil> {

    @Autowired
    PerfilService perfilService;

    @Override
    protected DefaultService<Perfil> getService() {
        return perfilService;
    }
}
