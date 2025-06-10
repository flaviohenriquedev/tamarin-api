package api.gommo._root._infra.multitenant;

import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.nio.file.AccessDeniedException;
import java.util.UUID;

@Component
public class FiltroTenantInterceptor implements HandlerInterceptor {
    @Autowired
    private UsuarioService usuarioService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AccessDeniedException {
        String clienteIdStr = request.getHeader("X-Empresa-Id");
        if (clienteIdStr != null) {
            UUID clienteId = UUID.fromString(clienteIdStr);
            var auth = SecurityContextHolder.getContext().getAuthentication();

            if (auth != null && auth.getPrincipal() instanceof Usuario usuario) {
                TenantContext.setUsuarioMaster(usuario.getUsuarioMaster());

                if (!usuario.getUsuarioMaster() &&
                    !usuarioService.possuiAcessoAoCliente(usuario.getId(), clienteId)) {
                    throw new AccessDeniedException("Acesso negado ao empresa informado.");
                }

                TenantContext.setClienteId(clienteId); // Salva clienteId no contexto da requisição
                Session session = entityManager.unwrap(Session.class);
                session.enableFilter("tenantFilter").setParameter("tenantId", clienteId);
            }
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }
}
