package api.gommo.departamentoPessoal.administracao.setor.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetorDTO extends EntidadeTenantDTO {
    private String descricao;
}
