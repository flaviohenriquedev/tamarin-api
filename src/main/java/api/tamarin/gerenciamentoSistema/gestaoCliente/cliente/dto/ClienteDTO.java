package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends EntidadeDTO {
    private String nomeFantasia;
    private String razaoSocial;
    private String cnpj;
    private LocalDate dataAbertura;
    private List<ClienteSistemaDTO> sistemas;
}