package api.gommo.gerenciamentoSistema.gestaoCliente.clienteSistema.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSistemaDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private ClienteDTO cliente;
    @JsonIgnore
    private PerfilSistemaDTO perfilSistema;
    private String keySistema;
}
