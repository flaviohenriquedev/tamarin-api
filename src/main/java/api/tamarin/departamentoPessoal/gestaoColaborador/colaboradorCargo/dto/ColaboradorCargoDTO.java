package api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.tamarin.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.tamarin.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.tamarin.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorCargoDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private ColaboradorDTO colaborador;
    private Date dataAdmissao;
    private Date vigenciaInicial;
    private Date vigenciaFinal;
    private CargoDTO cargo;
    private TipoContratoDTO tipoContrato;
    private CargaHorariaDTO cargaHoraria;
    private DepartamentoDTO departamento;
}
