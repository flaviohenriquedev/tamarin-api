package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController extends DefaultController<UsuarioDTO> {

    @Autowired
    private UsuarioService service;

    @Override
    protected DefaultService<UsuarioDTO> getService() {
        return service;
    }
}
