package api.tamarin.departamentoPessoal.administracao.cargo.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO extends EntidadeClienteDTO {
    private String descricao;
}

