package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.controller;

import api.tamarin._root.comum.controller.DefaultController;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model.UsuarioClienteSistemaPerfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.service.UsuarioClienteSistemaPerfilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario-cliente-sistema-perfil")
public class UsuarioClienteSistemaPerfilController extends DefaultController<UsuarioClienteSistemaPerfil> {

    @Autowired
    UsuarioClienteSistemaPerfilService usuarioClienteSistemaPerfilService;

    @Override
    protected DefaultService<UsuarioClienteSistemaPerfil> getService() {
        return usuarioClienteSistemaPerfilService;
    }
}
