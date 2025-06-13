package api.gommo._root._infra.multitenant;

import java.util.UUID;

public class TenantContext {
    private static final ThreadLocal<UUID> empresaId = new ThreadLocal<>();
    private static final ThreadLocal<Boolean> usuarioMaster = new ThreadLocal<>();

    public static void setEmpresaId(UUID id) {
        empresaId.set(id);
    }

    public static UUID getEmpresaId() {
        return empresaId.get();
    }

    public static void setUsuarioMaster(Boolean isMaster) {
        usuarioMaster.set(isMaster);
    }

    public static Boolean isUsuarioMaster() {
        return usuarioMaster.get() != null && usuarioMaster.get();
    }

    public static void clear() {
        empresaId.remove();
        usuarioMaster.remove();
    }
}

