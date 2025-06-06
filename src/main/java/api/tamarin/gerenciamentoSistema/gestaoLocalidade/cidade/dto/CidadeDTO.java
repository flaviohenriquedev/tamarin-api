package api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.dto.EstadoDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CidadeDTO extends EntidadePadraoDTO {
    private String nome;
    private EstadoDTO estado;
    private Integer ibge;
    private String latLon;
    private Integer codTom;
}
