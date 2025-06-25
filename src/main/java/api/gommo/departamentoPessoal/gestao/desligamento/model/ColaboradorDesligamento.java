package api.gommo.departamentoPessoal.gestao.desligamento.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.gestao.desligamento.enums.TipoDesligamentoCLTEnum;
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
@Table(name = "colaborador_desligamento")
public class ColaboradorDesligamento extends EntidadeTenant {
    @JoinColumn(name = "id_colaborador")
    @ManyToOne
    private Colaborador colaborador;

    @Column(name="data_desligamento")
    private LocalDate dataDesligamento;

    @Column(name = "tipo_desligamento")
    @Enumerated(EnumType.STRING)
    private TipoDesligamentoCLTEnum tipoDesligamento;

    @Column(name = "aviso_previo")
    private Boolean avisoPrevio;

    @Column(name = "data_inicio_aviso_previo")
    private LocalDate dataInicioAvisoPrevio;

    @Column(name = "data_fim_aviso_previo")
    private LocalDate dataFimAvisoPrevio;
}
