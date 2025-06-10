package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/perfil")
public class PerfilController extends DefaultController<PerfilDTO> {

    @Autowired
    private PerfilService perfilService;

    @Override
    protected DefaultService<PerfilDTO> getService() {
        return perfilService;
    }
}
