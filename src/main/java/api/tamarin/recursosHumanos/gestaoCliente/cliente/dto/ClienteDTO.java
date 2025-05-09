package api.tamarin.recursosHumanos.gestaoCliente.cliente.dto;

import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private LocalDate dataAbertura;
    private List<ClienteSistemaDTO> sistemas;
}