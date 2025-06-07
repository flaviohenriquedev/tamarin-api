package api.gommo.gerenciamentoSistema.gestaoLocalidade.estado.model;

import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.model.Pais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "estado")
public class Estado extends EntidadePadrao {

    private String nome;
    private String sigla;
    private Integer ibge;

    @JoinColumn(name = "id_pais")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pais pais;

    private List<Integer> ddd;
}
