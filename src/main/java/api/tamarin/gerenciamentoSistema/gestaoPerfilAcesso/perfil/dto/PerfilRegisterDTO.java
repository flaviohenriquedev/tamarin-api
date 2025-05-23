package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto;

import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
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
public class PerfilRegisterDTO {
    private ClienteDTO cliente;
    private String descricao;
    private List<PerfilSistemaDTO> sistemas;
}
