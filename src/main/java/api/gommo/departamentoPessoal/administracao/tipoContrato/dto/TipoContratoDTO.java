package api.gommo.departamentoPessoal.administracao.tipoContrato.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoContratoDTO extends EntidadeTenantDTO {
    private String descricao;
}
