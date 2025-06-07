package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
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
