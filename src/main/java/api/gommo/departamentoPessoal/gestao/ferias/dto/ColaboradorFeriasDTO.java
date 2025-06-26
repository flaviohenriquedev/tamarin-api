package api.gommo.departamentoPessoal.gestao.ferias.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorFeriasDTO extends EntidadeTenantDTO {
    private ColaboradorDTO colaborador;
    private LocalDate periodoInicial;
    private LocalDate periodoFinal;
    private String observacoes;
}
