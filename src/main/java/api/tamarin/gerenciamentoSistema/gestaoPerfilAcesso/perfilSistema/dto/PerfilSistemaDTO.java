package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto.PerfilSistemaModuloDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
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
public class PerfilSistemaDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private PerfilDTO perfil;
    private ClienteSistemaDTO clienteSistema;
    private List<PerfilSistemaModuloDTO> rotas;
}
