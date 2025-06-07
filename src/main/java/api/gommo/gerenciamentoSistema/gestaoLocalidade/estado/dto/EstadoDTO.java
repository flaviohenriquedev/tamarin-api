package api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.dto.PaisDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstadoDTO extends EntidadePadraoDTO {
    private String nome;
    private String sigla;
    private Integer ibge;
    private PaisDTO pais;
    private List<Integer> ddd;
}
