package api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.dto.EstadoDTO;
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
