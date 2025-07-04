package api.gommo.departamentoPessoal.gestao.afastamento.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorAfastamentoDTO extends EntidadeTenantDTO {
    private ColaboradorDTO colaborador;
    private LocalDate dataAfastamento;
}
