package api.gommo.gerenciamentoSistema.gestaoLocalidade.pais.model;

import api.gommo._root.comum.model.EntidadePadrao;
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
@Table(name = "pais")
public class Pais extends EntidadePadrao {
    private String nomePt;
    private String sigla;
    private Integer bacen;
    private Integer ddi;
}
