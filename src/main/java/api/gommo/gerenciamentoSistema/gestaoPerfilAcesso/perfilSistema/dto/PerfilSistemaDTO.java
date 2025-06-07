package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto.PerfilSistemaModuloDTO;
import api.gommo.gerenciamentoSistema.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
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
