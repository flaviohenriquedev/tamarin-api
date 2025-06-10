package api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioCliente.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTenantDTO extends EntidadeTenantDTO {
    @JsonIgnore
    private UsuarioDTO usuario;
}
