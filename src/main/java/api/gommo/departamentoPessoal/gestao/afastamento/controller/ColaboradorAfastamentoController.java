package api.gommo.departamentoPessoal.gestao.afastamento.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.gestao.afastamento.dto.ColaboradorAfastamentoDTO;
import api.gommo.departamentoPessoal.gestao.afastamento.service.ColaboradorAfastamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador-afastamento")
public class ColaboradorAfastamentoController extends DefaultController<ColaboradorAfastamentoDTO> {

    @Autowired
    private ColaboradorAfastamentoService colaboradorAfastamentoService;

    @Override
    protected DefaultService<ColaboradorAfastamentoDTO> getService() {
        return colaboradorAfastamentoService;
    }
}
