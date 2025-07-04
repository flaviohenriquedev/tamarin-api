package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model;

import api.gommo._root.comum.enums.EstadoCivilENUM;
import api.gommo._root.comum.enums.EtniaENUM;
import api.gommo._root.comum.enums.GeneroENUM;
import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador")
public class Colaborador extends EntidadeTenant {

    @Column(nullable = false, unique = true)
    private Integer matricula;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String cpf;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private LocalDate dataNascimento;

    @JoinColumn(name = "id_cidade_nascimento")
    @ManyToOne
    private Cidade cidadeNascimento;

    private String rg;
    private String telefone;

    @Column(name = "data_expedicao_rg")
    @Temporal(TemporalType.DATE)
    private LocalDate dataExpedicaoRg;

    private String nascionalidade;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    @Enumerated(EnumType.STRING)
    public EtniaENUM etnia;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    public EstadoCivilENUM estadoCivil;

    @Enumerated(EnumType.STRING)
    public GeneroENUM genero;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_colaborador")
    private StatusColaboradorENUM statusColaborador;

    @Column(name = "base_64", columnDefinition = "TEXT")
    private String base64;
}
