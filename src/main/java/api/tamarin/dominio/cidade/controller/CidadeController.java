package api.tamarin.dominio.cidade.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.dominio.cidade.model.Cidade;
import api.tamarin.dominio.cidade.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController extends DefaultController<Cidade> {

    @Autowired
    private CidadeService service;

    @Override
    protected DefaultService<Cidade> getService() {
        return service;
    }
}
