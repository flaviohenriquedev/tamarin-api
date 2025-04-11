package api.tamarin.colaborador.controller;

import api.tamarin._root.comum.controller.CRUDController;
import api.tamarin._root.comum.service.Service;
import api.tamarin.colaborador.model.Colaborador;
import api.tamarin.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController extends CRUDController<Colaborador> {

    @Autowired
    private ColaboradorService service;

    @Override
    protected Service<Colaborador> getService() {
        return service;
    }
}
