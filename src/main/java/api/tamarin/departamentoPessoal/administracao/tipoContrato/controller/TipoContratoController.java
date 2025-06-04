package api.tamarin.departamentoPessoal.administracao.tipoContrato.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.tamarin.departamentoPessoal.administracao.tipoContrato.service.TipoContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tipo-contrato")
public class TipoContratoController extends DefaultController<TipoContratoDTO> {

    @Autowired
    private TipoContratoService tipoContratoService;

    @Override
    protected DefaultService<TipoContratoDTO> getService() {
        return tipoContratoService;
    }
}
