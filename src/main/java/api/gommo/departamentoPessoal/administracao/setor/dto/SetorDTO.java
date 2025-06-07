package api.gommo.departamentoPessoal.administracao.setor.dto;

import api.gommo._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetorDTO extends EntidadeClienteDTO {
    private String descricao;
}
