package api.tamarin.departamentoPessoal.gestao.admissao.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissaoDTO extends EntidadeClienteDTO {
    private String descricao;
}
