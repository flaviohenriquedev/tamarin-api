package api.tamarin.departamentoPessoal.administracao.cargaHoraria.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CargaHorariaDTO extends EntidadeClienteDTO {
    private Integer horaInicial;
    private Integer horaFinal;
    private Integer horaAlmoco;
    private String descricao;
}
