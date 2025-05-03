package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.service.UsuarioPefilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario-perfil")
public class UsuarioPerfilController extends DefaultController<UsuarioPerfil> {

    @Autowired
    private UsuarioPefilService service;

    @Override
    protected DefaultService<UsuarioPerfil> getService() {
        return service;
    }
}
