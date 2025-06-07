package api.gommo.departamentoPessoal.administracao.departamento.dto;

import api.gommo._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDTO extends EntidadeClienteDTO {
    private String descricao;
}
