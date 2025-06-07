package api.gommo.departamentoPessoal.administracao.departamento.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController extends DefaultController<DepartamentoDTO> {

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    protected DefaultService<DepartamentoDTO> getService() {
        return departamentoService;
    }
}
