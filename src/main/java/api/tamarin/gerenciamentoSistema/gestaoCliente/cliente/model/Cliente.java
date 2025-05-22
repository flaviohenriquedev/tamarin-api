package api.tamarin.gerenciamentoSistema.gestaoCliente.cliente.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.model.ClienteSistema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeAuditavel {

    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Column(name = "razao_social")
    private String razaoSocial;

    @Column(name = "data_abertura")
    private LocalDate dataAbertura;

    @Column(name = "inscricao_estadual")
    private String inscricaoEstadual;

    @Column(name = "inscricao_municipal")
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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ClienteSistema> sistemas = new ArrayList<>();

}
