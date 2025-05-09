package api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.dto;

import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSistemaDTO {
    private Cliente cliente;
    private String keySistema;
}
