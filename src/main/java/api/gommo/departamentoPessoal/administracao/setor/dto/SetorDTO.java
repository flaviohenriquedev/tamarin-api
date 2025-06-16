package api.gommo.departamentoPessoal.administracao.setor.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SetorDTO extends EntidadeTenantDTO {
    private DepartamentoDTO departamento;
    private String descricao;
}
