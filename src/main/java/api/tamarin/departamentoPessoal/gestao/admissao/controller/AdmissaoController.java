package api.tamarin.departamentoPessoal.gestao.admissao.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamentoPessoal.gestao.admissao.dto.AdmissaoDTO;
import api.tamarin.departamentoPessoal.gestao.admissao.service.AdmissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admissao")
public class AdmissaoController extends DefaultController<AdmissaoDTO> {

    @Autowired
    private AdmissaoService admissaoService;

    @Override
    protected DefaultService<AdmissaoDTO> getService() {
        return admissaoService;
    }
}
