package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.dto.EmpresaSistemaDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.service.EmpresaSistemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("empresa-sistema")
public class EmpresaSistemaController extends DefaultController<EmpresaSistemaDTO> {

    @Autowired
    private EmpresaSistemaService empresaSistemaService;

    @Override
    protected DefaultService<EmpresaSistemaDTO> getService() {
        return empresaSistemaService;
    }
}
