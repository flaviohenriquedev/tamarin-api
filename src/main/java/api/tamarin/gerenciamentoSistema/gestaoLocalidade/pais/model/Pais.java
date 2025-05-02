package api.tamarin.gerenciamentoSistema.gestaoLocalidade.pais.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import jakarta.persistence.Column;
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
@Table(name = "pais")
public class Pais extends EntidadePadrao {
    String nome;

    @Column(name = "nome_pt")
    String nomePt;
    String sigla;
    Integer bacen;
    Integer ddi;
}
