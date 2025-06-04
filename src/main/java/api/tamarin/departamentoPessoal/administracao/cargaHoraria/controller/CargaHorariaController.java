package api.tamarin.departamentoPessoal.administracao.cargaHoraria.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.tamarin.departamentoPessoal.administracao.cargaHoraria.service.CargaHorariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carga-horaria")
public class CargaHorariaController extends DefaultController<CargaHorariaDTO> {

    @Autowired
    private CargaHorariaService cargaHorariaService;

    @Override
    protected DefaultService<CargaHorariaDTO> getService() {
        return cargaHorariaService;
    }
}
