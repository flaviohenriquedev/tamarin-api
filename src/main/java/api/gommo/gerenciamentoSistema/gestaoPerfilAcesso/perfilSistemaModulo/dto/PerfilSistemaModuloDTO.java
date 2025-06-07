package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilSistemaModuloDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private PerfilSistemaDTO perfilSistema;
    private String modulo;
    private List<String> roles;
}
