package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.records;

import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.model.Cliente;

import java.util.List;
import java.util.Map;

public record UsuarioRegister(
        Usuario usuario,
        List<Cliente> clientes,
        List<Map<String, String>> sistemasRoles,
        List<Perfil> perfis
) {
}
