package api.tamarin.departamentoPessoal.administracao.departamento.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDTO extends EntidadeClienteDTO {
    private String descricao;
}
