package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto;

import api.tamarin._root.comum.dto.EntidadeAuditavelDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioPerfilDTO extends EntidadeAuditavelDTO {
    @JsonIgnore
    private UsuarioDTO usuario;
    private PerfilSistemaDTO perfilSistema;
}
