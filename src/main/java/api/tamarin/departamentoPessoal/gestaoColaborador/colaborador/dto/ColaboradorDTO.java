package api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto.ColaboradorEnderecoDTO;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDTO extends EntidadeClienteDTO {
    private String nomeCompleto;
    private String cpf;
    private Date dataNascimento;
    private String nascionalidade;
    private String nomeMae;
    private StatusColaboradorENUM statusColaborador;
    private ColaboradorEnderecoDTO colaboradorEndereco;
    private ColaboradorCargoDTO cargoAtivo;
    private List<ColaboradorCargoDTO> listaColaboradorCargo;

    public ColaboradorCargoDTO getCargoAtivo() {
        if (Objects.nonNull(listaColaboradorCargo) && !listaColaboradorCargo.isEmpty()) {
            return listaColaboradorCargo.stream().filter(cc -> Objects.isNull(cc.getVigenciaFinal())).findFirst().orElse(new ColaboradorCargoDTO());
        }
        return new ColaboradorCargoDTO();
    }
}
