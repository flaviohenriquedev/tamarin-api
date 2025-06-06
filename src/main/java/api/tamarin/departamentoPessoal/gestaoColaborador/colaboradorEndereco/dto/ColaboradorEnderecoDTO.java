package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorEnderecoDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private ColaboradorDTO colaborador;
    private String rua;
    private String quadra;
    private String lote;
    private String numero;
    private String bairro;
    private CidadeDTO cidade;
}
