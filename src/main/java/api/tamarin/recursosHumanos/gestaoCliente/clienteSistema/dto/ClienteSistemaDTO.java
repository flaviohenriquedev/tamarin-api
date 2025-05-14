package api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.dto;

import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSistemaDTO {
    private PerfilSistemaDTO perfilSistema;
    private ClienteDTO cliente;
    private String keySistema;
}
