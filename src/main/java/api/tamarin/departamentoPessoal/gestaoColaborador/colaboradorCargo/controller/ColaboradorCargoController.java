package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.service.ColaboradorCargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador-cargo")
public class ColaboradorCargoController extends DefaultController<ColaboradorCargoDTO> {

    @Autowired
    private ColaboradorCargoService colaboradorCargoService;

    @Override
    protected DefaultService<ColaboradorCargoDTO> getService() {
        return colaboradorCargoService;
    }
}
