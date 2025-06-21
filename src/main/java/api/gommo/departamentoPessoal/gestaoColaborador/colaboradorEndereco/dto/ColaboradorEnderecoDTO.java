package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
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
    private String complemento;
    private String numero;
    private String bairro;
    private CidadeDTO cidade;
}
