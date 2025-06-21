package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.enums.FormaPagamentoENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.enums.TipoSalarioENUM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
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
    private BigDecimal salario;
    private Integer quantidadeDiasExperiencia;
    private LocalDate dataExperiencia;
    private Integer quantidadeDiasProrrogacao;
    private LocalDate dataProrrogacao;
    private Boolean possuiSindicato;
    private FormaPagamentoENUM formaPagamento;
    private TipoSalarioENUM tipoSalario;
}
