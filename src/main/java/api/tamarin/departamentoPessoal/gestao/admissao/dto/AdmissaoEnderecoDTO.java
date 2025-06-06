package api.tamarin.departamentoPessoal.gestao.admissao.dto;

import api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissaoEnderecoDTO {
    private String rua;
    private String quadra;
    private String lote;
    private String numero;
    private String bairro;
    private CidadeDTO cidade;
}
