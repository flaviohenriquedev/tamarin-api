package api.tamarin.pessoa.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.pessoa.model.Pessoa;
import api.tamarin.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoa")
public class PessoaController extends DefaultController<Pessoa> {

    @Autowired
    private PessoaService service;

    @Override
    protected DefaultService<Pessoa> getService() {
        return service;
    }
}
