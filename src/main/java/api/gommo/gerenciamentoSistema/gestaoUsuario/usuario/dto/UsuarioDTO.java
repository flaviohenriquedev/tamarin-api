package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.gommo._root.comum.dto.EntidadeAuditavelDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.*;

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
    private Set<EmpresaDTO> empresas = new HashSet<>();

    @JsonIgnore
    private String senha;

    public UsuarioDTO(UUID id) {
        super.setId(id);
    }
}
