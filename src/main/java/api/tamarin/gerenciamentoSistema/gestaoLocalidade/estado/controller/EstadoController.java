package api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController extends DefaultController<Estado> {

    @Autowired
    private EstadoService service;

    @Override
    protected DefaultService<Estado> getService() {
        return service;
    }
}
