package api.tamarin.dominio.pais.controller;

import api.tamarin._root.comum.controller.CRUDController;
import api.tamarin._root.comum.service.Service;
import api.tamarin.dominio.pais.model.Pais;
import api.tamarin.dominio.pais.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController extends CRUDController<Pais> {

    @Autowired
    private PaisService service;

    @Override
    protected Service<Pais> getService() {
        return service;
    }
}
