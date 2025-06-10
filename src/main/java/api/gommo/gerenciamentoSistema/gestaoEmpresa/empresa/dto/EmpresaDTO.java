package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.dto.EmpresaSistemaDTO;
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
public class EmpresaDTO extends EntidadePadraoDTO {
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
    private List<EmpresaSistemaDTO> sistemas;

    public EmpresaDTO(UUID id) {
        super.setId(id);
    }
}