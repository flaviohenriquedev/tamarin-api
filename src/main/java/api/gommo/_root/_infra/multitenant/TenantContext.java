package api.gommo._root._infra.multitenant;

import java.util.UUID;

public class TenantContext {
    private static final ThreadLocal<UUID> clienteId = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> usuarioMaster = new ThreadLocal<>();

    public static void setClienteId(UUID id) {
        clienteId.set(id);
    }

    public static UUID getClienteId() {
        return clienteId.get();
    }

    public static void setUsuarioMaster(Boolean isMaster) {
        usuarioMaster.set(isMaster);
    }

    public static Boolean isUsuarioMaster() {
        return usuarioMaster.get() != null && usuarioMaster.get();
    }

    public static void clear() {
        clienteId.remove();
        usuarioMaster.remove();
    }
}

