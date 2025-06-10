package api.gommo.departamentoPessoal.administracao.cargo.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO extends EntidadeTenantDTO {
    private String descricao;
}

