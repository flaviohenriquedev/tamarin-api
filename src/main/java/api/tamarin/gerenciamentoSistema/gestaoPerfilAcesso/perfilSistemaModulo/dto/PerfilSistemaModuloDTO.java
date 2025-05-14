package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilSistemaModuloDTO extends EntidadeDTO {
    private PerfilSistemaDTO perfilSistema;
    private String modulo;
    private List<String> roles;
}
