package api.tamarin.recursosHumanos.gestaoCliente.cliente.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model.ClienteSistema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeAuditavel {
    @Column(name = "nome_fantasia")
    String nomeFantasia;

    @Column(name = "razao_social")
    String razaoSocial;

    String cnpj;

    @Column(name = "data_abertura")
    LocalDate dataAbertura;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ClienteSistema> sistemas = new ArrayList<>();

}
