package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.dto.ClienteSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO extends EntidadeDTO {
    private String nomeFantasia;
    private String razaoSocial;
    private LocalDate dataAbertura;
    private String inscricaoEstadual;
    private String inscricaoMunicipal;
    private String cnpj;
    private String telefone;
    private String email;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private List<ClienteSistemaDTO> sistemas;

    public ClienteDTO(UUID id) {
        super.setId(id);
    }
}