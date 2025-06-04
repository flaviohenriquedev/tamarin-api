package api.tamarin.departamentoPessoal.administracao.tipoContrato.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoContratoDTO extends EntidadeClienteDTO {
    private String descricao;
}
