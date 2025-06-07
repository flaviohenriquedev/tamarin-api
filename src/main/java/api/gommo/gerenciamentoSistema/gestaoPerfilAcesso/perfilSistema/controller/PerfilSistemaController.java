package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.service.PerfilSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil-sistema")
public class PerfilSistemaController extends DefaultController<PerfilSistemaDTO> {

    @Autowired
    private PerfilSistemaService perfilSistemaService;

    @Override
    protected DefaultService<PerfilSistemaDTO> getService() {
        return perfilSistemaService;
    }
}
