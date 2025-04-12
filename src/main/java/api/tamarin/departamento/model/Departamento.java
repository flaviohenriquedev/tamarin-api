package api.tamarin.departamento.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "departamento")
public class Departamento extends EntidadeCliente {

    String descricao;
}
