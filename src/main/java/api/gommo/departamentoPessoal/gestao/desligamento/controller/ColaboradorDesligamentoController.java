package api.gommo.departamentoPessoal.gestao.desligamento.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.gestao.desligamento.dto.ColaboradorDesligamentoDTO;
import api.gommo.departamentoPessoal.gestao.desligamento.service.ColaboradorDesligamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador-desligamento")
public class ColaboradorDesligamentoController extends DefaultController<ColaboradorDesligamentoDTO> {

    @Autowired
    private ColaboradorDesligamentoService colaboradorDesligamentoService;

    @Override
    protected DefaultService<ColaboradorDesligamentoDTO> getService() {
        return colaboradorDesligamentoService;
    }
}
