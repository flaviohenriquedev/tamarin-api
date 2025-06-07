package api.gommo.departamentoPessoal.administracao.cargaHoraria.dto;

import api.gommo._root.comum.dto.EntidadeClienteDTO;
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
