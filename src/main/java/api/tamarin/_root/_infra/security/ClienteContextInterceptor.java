package api.tamarin._root._infra.security;

import api.tamarin._root._infra.service.ClienteContextService;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class ClienteContextInterceptor implements HandlerInterceptor {

    @Autowired
    private ClienteContextService clienteContextService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String clienteId = request.getHeader("X-Cliente-Id");
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);

            String email = tokenService.validateToken(token); // <- pega o e-mail do usuário

            if (email != null) {
                Usuario usuario = usuarioRepository.findByEmail(email)
                        .orElse(null); // evitar lançar exceção aqui

                if (usuario != null && !Boolean.TRUE.equals(usuario.getUsuarioMaster())) {
                    if (clienteId != null && !clienteId.isBlank()) {
                        clienteContextService.setClienteId(clienteId);
                    }
                }
            }
        }

        return true; // sempre deixa seguir
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        clienteContextService.clear();
    }
}
