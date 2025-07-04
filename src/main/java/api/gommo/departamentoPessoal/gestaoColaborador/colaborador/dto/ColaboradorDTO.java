package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo._root.comum.enums.EstadoCivilENUM;
import api.gommo._root.comum.enums.EtniaENUM;
import api.gommo._root.comum.enums.GeneroENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto.ColaboradorCargoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.dto.ColaboradorEnderecoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDTO extends EntidadeTenantDTO {
    private Integer matricula;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private CidadeDTO cidadeNascimento;
    private String rg;
    private String telefone;
    private String email;
    private LocalDate dataExpedicaoRg;
    private String nascionalidade;
    private String nomeMae;
    private String nomePai;
    public EtniaENUM etnia;
    public EstadoCivilENUM estadoCivil;
    public GeneroENUM genero;

    private StatusColaboradorENUM statusColaborador;

    private ColaboradorEnderecoDTO colaboradorEndereco;
    private ColaboradorCargoDTO cargoAtivo;
    private List<ColaboradorCargoDTO> listaColaboradorCargo;
    private String base64;

    public ColaboradorCargoDTO getCargoAtivo() {
        if (Objects.nonNull(listaColaboradorCargo) && !listaColaboradorCargo.isEmpty()) {
            return listaColaboradorCargo.stream().filter(cc -> Objects.isNull(cc.getVigenciaFinal())).findFirst().orElse(new ColaboradorCargoDTO());
        }
        return new ColaboradorCargoDTO();
    }
}
