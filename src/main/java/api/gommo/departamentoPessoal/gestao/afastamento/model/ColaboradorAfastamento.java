package api.gommo.departamentoPessoal.gestao.afastamento.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador_afastamento")
public class ColaboradorAfastamento extends EntidadeTenant {

    @JoinColumn(name = "id_colaborador")
    @ManyToOne(fetch = FetchType.LAZY)
    private Colaborador colaborador;

    @Column(name = "data_afastamento")
    private LocalDate dataAfastamento;
}
