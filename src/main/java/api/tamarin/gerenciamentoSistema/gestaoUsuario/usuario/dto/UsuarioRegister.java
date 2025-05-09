package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;

import java.util.List;
import java.util.Map;

public record UsuarioRegister(
        Usuario usuario,
        List<Cliente> clientes,
        List<Map<String, String>> sistemasRoles,
        List<Perfil> perfis
) {
}
