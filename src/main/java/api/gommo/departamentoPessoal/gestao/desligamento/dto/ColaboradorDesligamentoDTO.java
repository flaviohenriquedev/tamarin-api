package api.gommo.departamentoPessoal.gestao.desligamento.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.gestao.desligamento.enums.TipoDesligamentoCLTEnum;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDesligamentoDTO extends EntidadeTenantDTO {
    private ColaboradorDTO colaborador;
    private LocalDate dataDesligamento;
    private TipoDesligamentoCLTEnum tipoDesligamento;
    private Boolean avisoPrevio;
    private LocalDate dataInicioAvisoPrevio;
    private LocalDate dataFimAvisoPrevio;
}
