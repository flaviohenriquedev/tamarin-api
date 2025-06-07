package api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.dto.EstadoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController extends DefaultController<EstadoDTO> {

    @Autowired
    private EstadoService estadoService;

    @Override
    protected DefaultService<EstadoDTO> getService() {
        return estadoService;
    }
}
