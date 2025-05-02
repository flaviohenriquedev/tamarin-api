package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.model.Colaborador;
import api.tamarin.recursosHumanos.gestaoColaborador.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController extends DefaultController<Colaborador> {

    @Autowired
    private ColaboradorService service;

    @Override
    protected DefaultService<Colaborador> getService() {
        return service;
    }
}
