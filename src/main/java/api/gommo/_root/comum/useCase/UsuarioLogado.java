package api.gommo._root.comum.useCase;

import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import org.springframework.security.core.context.SecurityContextHolder;

public class UsuarioLogado {

    private Usuario usuario;

    public static Usuario getUsuario() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof Usuario) {
            return (Usuario) principal;
        }
        return new Usuario();
    }
}
