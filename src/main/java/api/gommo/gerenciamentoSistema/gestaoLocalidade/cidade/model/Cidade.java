package api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model;

import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.model.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cidade")
public class Cidade extends EntidadePadrao {
    private String nome;
    private Integer ibge;

    @Column(name = "lat_lon")
    private String latLon;

    @Column(name = "cod_tom")
    private Integer codTom;
    
    @JoinColumn(name = "id_estado")
    @ManyToOne(fetch = FetchType.LAZY)
    private Estado estado;
}
