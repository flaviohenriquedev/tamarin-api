package api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.model.Pais;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController extends DefaultController<Pais> {

    @Autowired
    private PaisService service;

    @Override
    protected DefaultService<Pais> getService() {
        return service;
    }
}
