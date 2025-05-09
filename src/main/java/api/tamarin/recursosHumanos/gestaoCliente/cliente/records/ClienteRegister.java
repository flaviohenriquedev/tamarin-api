package api.tamarin.recursosHumanos.gestaoCliente.cliente.records;

import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model.ClienteSistema;

import java.util.List;

public record ClienteRegister(
        Cliente cliente,
        List<ClienteSistema> sistemas
) {
}
