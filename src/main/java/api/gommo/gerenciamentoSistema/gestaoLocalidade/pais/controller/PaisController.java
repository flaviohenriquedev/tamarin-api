package api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.dto.PaisDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pais")
public class PaisController extends DefaultController<PaisDTO> {

    @Autowired
    private PaisService paisService;

    @Override
    protected DefaultService<PaisDTO> getService() {
        return paisService;
    }
}
