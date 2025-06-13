package api.gommo._root._infra.multitenant;

import api.gommo._root.comum.enums.SistemaENUM;
import com.fasterxml.jackson.core.type.TypeReference;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import java.util.Map;
import java.util.UUID;

@Component
public class FiltroTenantInterceptor implements HandlerInterceptor {
    @Autowired
    private UsuarioService usuarioService;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AccessDeniedException {
        String filtersData = request.getHeader("X-Filters-Data");

        if (filtersData != null && !filtersData.isEmpty()) {
            try {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, String> filters = mapper.readValue(filtersData, new TypeReference<>() {});

                String empresaIdStr = filters.get("empresaId");
                String sistemaSelecionado = filters.get("sistemaSelecionado");

                if (empresaIdStr != null) {
                    UUID empresaId = UUID.fromString(empresaIdStr);
                    var auth = SecurityContextHolder.getContext().getAuthentication();

                    if (auth != null && auth.getPrincipal() instanceof Usuario usuario) {
                        TenantContext.setUsuarioMaster(usuario.getUsuarioMaster());

                        if (!usuario.getUsuarioMaster() &&
                            !usuarioService.possuiAcessoAEmpresa(usuario.getId(), empresaId)) {
                            throw new AccessDeniedException("Acesso negado à empresa informada.");
                        }

                        TenantContext.setEmpresaId(empresaId);
                        Session session = entityManager.unwrap(Session.class);
                        session.enableFilter("tenantFilter").setParameter("tenantId", empresaId);
                    }
                }

                if (sistemaSelecionado != null && !sistemaSelecionado.isEmpty()) {
                    TenantContext.setSistemaSelecionado(sistemaSelecionado);
                    Session session = entityManager.unwrap(Session.class);
                    session.enableFilter("sistemaFilter").setParameter("sistema", sistemaSelecionado);
                }

            } catch (Exception e) {
                throw new RuntimeException("Erro ao processar header X-Filters-Data: " + e.getMessage(), e);
            }
        }

        return true;
    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        TenantContext.clear();
    }
}
