package api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaisDTO extends EntidadePadraoDTO {
    private String nomePt;
    private String sigla;
    private Integer bacen;
    private Integer ddi;
}
