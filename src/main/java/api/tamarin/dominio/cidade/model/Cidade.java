package api.tamarin.dominio.cidade.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.dominio.estado.model.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cidade")
public class Cidade extends EntidadePadrao {
    String nome;

    @ManyToOne
    @JoinColumn
    Estado estado;
}
