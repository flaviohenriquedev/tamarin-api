package api.tamarin.gerenciamentoSistema.gestaoLocalidade.cidade.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import jakarta.persistence.*;
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
    @JoinColumn(name = "estado")
    Estado estado;

    Integer ibge;
    @Column(name = "lat_lon")
    String latLon;

    @Column(name = "cod_tom", columnDefinition = "INTEGER DEFAULT 0")
    private Integer codTom = 0;
}
