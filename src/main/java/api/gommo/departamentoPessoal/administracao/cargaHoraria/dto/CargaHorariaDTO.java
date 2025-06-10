package api.gommo.departamentoPessoal.administracao.cargaHoraria.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CargaHorariaDTO extends EntidadeTenantDTO {
    private Integer horaInicial;
    private Integer horaFinal;
    private Integer horaAlmoco;
    private String descricao;
}
