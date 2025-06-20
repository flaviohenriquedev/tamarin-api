package api.gommo.departamentoPessoal.administracao.cargo.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.cargo.service.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cargo")
public class CargoController extends DefaultController<CargoDTO> {

    @Autowired
    private CargoService cargoService;

    @Override
    protected DefaultService<CargoDTO> getService() {
        return cargoService;
    }
}
