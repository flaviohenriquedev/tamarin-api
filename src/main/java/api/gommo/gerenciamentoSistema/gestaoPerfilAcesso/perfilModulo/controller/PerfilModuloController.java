package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto.PerfilModuloDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.service.PerfilModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/perfil-modulo")
public class PerfilModuloController extends DefaultController<PerfilModuloDTO> {

    @Autowired
    private PerfilModuloService perfilModuloService;

    @Override
    protected DefaultService<PerfilModuloDTO> getService() {
        return perfilModuloService;
    }
}
