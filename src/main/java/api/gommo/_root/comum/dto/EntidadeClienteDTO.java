package api.gommo._root.comum.dto;

import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntidadeClienteDTO extends EntidadeAuditavelDTO {
    private ClienteDTO cliente;
}
