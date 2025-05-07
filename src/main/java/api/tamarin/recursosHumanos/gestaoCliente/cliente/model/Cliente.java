package api.tamarin.recursosHumanos.gestaoCliente.cliente.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    Date dataAbertura;

    List<String> sistemas;

}
