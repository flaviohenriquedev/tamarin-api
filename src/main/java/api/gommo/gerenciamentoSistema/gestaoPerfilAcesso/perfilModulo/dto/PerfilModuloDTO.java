package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo._root.comum.enums.FuncionalidadeENUM;
import api.gommo._root.comum.enums.ModuloENUM;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PerfilModuloDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private PerfilDTO perfil;
    private ModuloENUM modulo;
    private List<FuncionalidadeENUM> funcionalidades = new ArrayList<>();
}
