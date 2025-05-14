package api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto.ClienteDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteSistemaDTO extends EntidadeDTO {
    @JsonIgnore
    private ClienteDTO cliente;
    @JsonIgnore
    private PerfilSistemaDTO perfilSistema;
    private String keySistema;
}
