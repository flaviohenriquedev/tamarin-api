package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto;

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
public class PerfilDTO extends EntidadeDTO {
    String descricao;
    List<PerfilSistemaDTO> sistemas;
}
