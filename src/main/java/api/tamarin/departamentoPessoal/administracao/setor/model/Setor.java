package api.tamarin.departamentoPessoal.administracao.setor.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "setor")
public class Setor extends EntidadeCliente {
    private String descricao;
}
