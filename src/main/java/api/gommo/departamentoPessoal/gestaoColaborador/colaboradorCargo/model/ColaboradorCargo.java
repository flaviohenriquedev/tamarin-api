package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.model;

import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.model.CargaHoraria;
import api.gommo.departamentoPessoal.administracao.cargo.model.Cargo;
import api.gommo.departamentoPessoal.administracao.departamento.model.Departamento;
import api.gommo.departamentoPessoal.administracao.tipoContrato.model.TipoContrato;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador_cargo")
public class ColaboradorCargo extends EntidadePadrao {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    @Column(name = "vigencia_inicial")
    @Temporal(TemporalType.DATE)
    private Date vigenciaInicial;

    @Column(name = "vigencia_final")
    @Temporal(TemporalType.DATE)
    private Date vigenciaFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cargo")
    private Cargo cargo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_contrato")
    private TipoContrato tipoContrato;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_carga_horaria")
    private CargaHoraria cargaHoraria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;
}
