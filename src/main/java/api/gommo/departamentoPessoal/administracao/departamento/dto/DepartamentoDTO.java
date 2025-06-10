package api.gommo.departamentoPessoal.administracao.departamento.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDTO extends EntidadeTenantDTO {
    private String descricao;
}
