package api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto;

import api.gommo._root.comum.dto.EntidadeAuditavelDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto.UsuarioDTO;
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
    private PerfilDTO perfil;
}
