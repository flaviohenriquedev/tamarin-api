package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDTO extends EntidadeTenantDTO {
    private String descricao;
    private List<PerfilSistemaDTO> sistemas;

    public PerfilDTO(UUID id) {
        super.setId(id);
    }
}
