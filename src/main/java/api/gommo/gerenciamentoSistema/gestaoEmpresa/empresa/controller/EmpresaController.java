package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.service.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController extends DefaultController<EmpresaDTO> {

    @Autowired
    private EmpresaService clienteService;

    @Override
    protected DefaultService<EmpresaDTO> getService() {
        return clienteService;
    }

    @PostMapping("/salvar-em-massa")
    public void salvarEmMassa(@RequestBody List<EmpresaDTO> lista) {
        clienteService.salvarEmMassa(lista);
    }
}
