package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import api.tamarin.recursosHumanos.gestaoPessoa.pessoa.model.Pessoa;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "colaborador")
public class Colaborador extends EntidadeCliente {
    @OneToOne
    @JoinColumn
    Pessoa pessoa;
    Date dataAdmissao;
    Date dataDemissao;
}
