package api.tamarin.departamentoPessoal.administracao.setor.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetorDTO extends EntidadeClienteDTO {
    private String descricao;
}
