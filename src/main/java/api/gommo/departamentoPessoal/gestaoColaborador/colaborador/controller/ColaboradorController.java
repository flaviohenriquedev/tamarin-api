package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/listar-colaboradores-desligados")
    public Set<ColaboradorDTO> listarColaboradoresDesligados() {
        return colaboradorService.listarColaboradoresDesligados();
    }

    @GetMapping("/buscar-por-matricula/{matricula}")
    public ColaboradorDTO findByMatricula(@PathVariable Integer matricula) {
        return colaboradorService.findByMatricula(matricula);
    }

    @GetMapping("/buscar-por-cpf/{cpf}")
    public ColaboradorDTO findByCpf(@PathVariable String cpf) {
        return colaboradorService.findByCpf(cpf);
    }
}
