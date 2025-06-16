package api.gommo.departamentoPessoal.administracao.departamento.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.administracao.setor.dto.SetorDTO;
import api.gommo.departamentoPessoal.administracao.setor.model.Setor;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartamentoDTO extends EntidadeTenantDTO {
    private String descricao;
    private List<SetorDTO> setores;
}
