package api.gommo.departamentoPessoal.gestao.desligamento.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador-desligamento")
public class ColaboradorDesligamento extends EntidadeTenant {
    @JoinColumn(name = "id_colaborador")
    @ManyToOne
    private Colaborador colaborador;
}
