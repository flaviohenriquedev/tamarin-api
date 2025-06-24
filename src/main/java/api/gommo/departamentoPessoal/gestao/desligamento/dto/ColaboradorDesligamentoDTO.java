package api.gommo.departamentoPessoal.gestao.desligamento.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDesligamentoDTO extends EntidadeTenantDTO {
    private ColaboradorDTO colaborador;
}
