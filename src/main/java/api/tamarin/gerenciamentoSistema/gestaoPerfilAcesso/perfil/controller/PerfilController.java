package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.service.PerfilService;
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

    @GetMapping("/buscar-por-id-cliente/{idCliente}")
    public Set<PerfilDTO> buscarPorIdCliente(@PathVariable UUID idCliente) {
        return perfilService.buscarPorIdCliente(idCliente);
    }

    @GetMapping("/buscar-por-id-cliente-sistema/{idClienteSistema}")
    public Set<PerfilDTO> buscarPorIdClienteSistema(@PathVariable UUID idClienteSistema) {
        return perfilService.buscarPorIdClienteSistema(idClienteSistema);
    }
}
