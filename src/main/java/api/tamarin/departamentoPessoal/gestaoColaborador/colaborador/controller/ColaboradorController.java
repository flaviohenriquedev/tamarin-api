package api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/colaborador")
public class ColaboradorController extends DefaultController<ColaboradorDTO> {

    @Autowired
    private ColaboradorService colaboradorService;

    @Override
    protected DefaultService<ColaboradorDTO> getService() {
        return colaboradorService;
    }

    @GetMapping("/listar-colaboradores-ativos")
    public Set<ColaboradorDTO> listarColaboradoresAtivos() {
        return colaboradorService.listarColaboradoresAtivos();
    }
}
