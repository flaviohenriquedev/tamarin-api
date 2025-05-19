package api.tamarin._root._infra.service;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteContextService {

    @Autowired
    private EntityManager entityManager;

    private static final ThreadLocal<String> clienteIdHolder = new ThreadLocal<>();

    @Transactional
    public void setClienteId(String clienteId, Boolean isUsuarioMaster) {
        if (isUsuarioMaster) {
            // Limpa a variável de sessão do PostgreSQL
            entityManager.createNativeQuery("RESET app.current_id_cliente").executeUpdate();
            clienteIdHolder.remove();
        } else {
            String sql = "SET app.current_id_cliente = '" + clienteId + "'";
            entityManager.createNativeQuery(sql).executeUpdate();
            clienteIdHolder.set(clienteId);
        }
    }
    public String getClienteId() {
        return clienteIdHolder.get();
    }

    public void clear() {
        clienteIdHolder.remove();
    }
}