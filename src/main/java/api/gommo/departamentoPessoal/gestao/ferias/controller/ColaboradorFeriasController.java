package api.gommo.departamentoPessoal.gestao.ferias.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.gestao.ferias.dto.ColaboradorFeriasDTO;
import api.gommo.departamentoPessoal.gestao.ferias.service.ColaboradorFeriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colaborador-ferias")
public class ColaboradorFeriasController extends DefaultController<ColaboradorFeriasDTO> {

    @Autowired
    private ColaboradorFeriasService colaboradorFeriasService;

    @Override
    protected DefaultService<ColaboradorFeriasDTO> getService() {
        return colaboradorFeriasService;
    }
}
