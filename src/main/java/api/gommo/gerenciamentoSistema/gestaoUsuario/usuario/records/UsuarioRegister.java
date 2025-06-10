package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.records;

import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;

import java.util.List;
import java.util.Map;

public record UsuarioRegister(
        Usuario usuario,
        List<Empresa> empresas,
        List<Map<String, String>> sistemasRoles,
        List<Perfil> perfis
) {
}
