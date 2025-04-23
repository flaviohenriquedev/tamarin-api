package api.tamarin.departamento.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamento.model.Departamento;
import api.tamarin.departamento.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController extends DefaultController<Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    protected DefaultService<Departamento> getService() {
        return service;
    }
}
