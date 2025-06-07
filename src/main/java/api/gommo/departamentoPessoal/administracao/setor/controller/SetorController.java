package api.gommo.departamentoPessoal.administracao.setor.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.administracao.setor.dto.SetorDTO;
import api.gommo.departamentoPessoal.administracao.setor.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/setor")
public class SetorController extends DefaultController<SetorDTO> {

    @Autowired
    private SetorService setorService;

    @Override
    protected DefaultService<SetorDTO> getService() {
        return setorService;
    }
}
