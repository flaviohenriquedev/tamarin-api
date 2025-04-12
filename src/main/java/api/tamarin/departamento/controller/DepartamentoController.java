package api.tamarin.departamento.controller;

import api.tamarin._root.comum.controller.CRUDController;
import api.tamarin._root.comum.service.Service;
import api.tamarin.departamento.model.Departamento;
import api.tamarin.departamento.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController extends CRUDController<Departamento> {

    @Autowired
    private DepartamentoService service;

    @Override
    protected Service<Departamento> getService() {
        return service;
    }
}
