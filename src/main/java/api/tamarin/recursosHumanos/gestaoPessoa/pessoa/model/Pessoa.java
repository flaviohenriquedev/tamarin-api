package api.tamarin.recursosHumanos.gestaoPessoa.pessoa.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa extends EntidadeCliente {
    String nomeCompleto;
    String cpf;
    String cnpj;
    String rg;
    Date dataNascimento;
}
