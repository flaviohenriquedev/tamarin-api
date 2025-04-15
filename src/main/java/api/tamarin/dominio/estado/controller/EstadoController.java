package api.tamarin.dominio.estado.controller;

import api.tamarin._root.comum.controller.CRUDController;
import api.tamarin._root.comum.service.Service;
import api.tamarin.dominio.estado.model.Estado;
import api.tamarin.dominio.estado.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estado")
public class EstadoController extends CRUDController<Estado> {

    @Autowired
    private EstadoService service;

    @Override
    protected Service<Estado> getService() {
        return service;
    }
}
