package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto.PerfilDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.dto.PerfilSistemaModuloDTO;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilSistemaDTO extends EntidadeDTO {
    private PerfilDTO perfil;
    private ClienteSistemaDTO clienteSistema;
    private List<PerfilSistemaModuloDTO> rotas;
}
