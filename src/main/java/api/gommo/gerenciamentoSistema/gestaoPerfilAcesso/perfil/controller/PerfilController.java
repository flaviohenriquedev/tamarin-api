package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/perfil")
public class PerfilController extends DefaultController<PerfilDTO> {

    @Autowired
    private PerfilService perfilService;

    @Override
    protected DefaultService<PerfilDTO> getService() {
        return perfilService;
    }

    @GetMapping("/listar-perfis-por-sistema/{sistema}")
    public List<PerfilDTO> listarPerfisPorSistema(@PathVariable SistemaENUM sistema) {
        return perfilService.listarPerfisPorSistema(sistema);
    }
}
