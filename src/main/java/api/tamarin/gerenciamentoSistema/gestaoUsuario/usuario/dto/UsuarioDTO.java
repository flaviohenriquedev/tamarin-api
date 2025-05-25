package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.tamarin._root.comum.dto.EntidadeAuditavelDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioDTO extends EntidadeAuditavelDTO {
    private String nome;
    private String email;
    private String cpf;
    private String token;
    private StatusUsuarioENUM statusUsuario;
    private Boolean usuarioMaster = Boolean.FALSE;
    private List<UsuarioPerfilDTO> perfis = new ArrayList<>();

    @JsonIgnore
    private String senha;

    public UsuarioDTO(UUID id) {
        super.setId(id);
    }
}
