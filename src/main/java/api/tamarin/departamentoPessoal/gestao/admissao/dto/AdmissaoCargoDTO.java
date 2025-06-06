package api.tamarin.departamentoPessoal.gestao.admissao.dto;

import api.tamarin.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.tamarin.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.tamarin.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.tamarin.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissaoCargoDTO {
    private BigDecimal salario;
    private Timestamp dataAdmissao;
    private CargoDTO cargo;
    private TipoContratoDTO tipoContrato;
    private CargaHorariaDTO cargaHoraria;
    private DepartamentoDTO departamento;
}
