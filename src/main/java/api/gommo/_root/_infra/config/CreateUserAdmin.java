package api.gommo._root._infra.config;

import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.boot.context.event.ApplicationReadyEvent;

@Component
public class CreateUserAdmin {

    @Autowired
    private UsuarioService usuarioService;

    @EventListener(ApplicationReadyEvent.class)
    public void createUserAdmin() {
        String email = "admin@admin";
        if (!usuarioService.existePorEmail(email)) {
            usuarioService.createUserAdmin(email);
        }
    }
}
