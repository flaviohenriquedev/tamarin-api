package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.controller;

import api.gommo._root.comum.controller.DefaultController;
import api.gommo._root.comum.service.DefaultService;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/buscarUsuarioPorEmail/{email}")
    public ResponseEntity<UsuarioDTO> buscarUsuarioPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(service.buscarUsuarioPorEmail(email));
    }
}
