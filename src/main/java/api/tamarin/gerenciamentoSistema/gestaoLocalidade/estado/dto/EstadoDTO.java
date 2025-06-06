package api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.dto.PaisDTO;
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
