package api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cidade")
public class CidadeController extends DefaultController<CidadeDTO> {

    @Autowired
    private CidadeService cidadeService;

    @Override
    protected DefaultService<CidadeDTO> getService() {
        return cidadeService;
    }
}
