package api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
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
