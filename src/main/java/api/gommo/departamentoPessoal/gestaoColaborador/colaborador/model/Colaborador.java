package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

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
    private String rg;

    @Column(name = "data_nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String nascionalidade;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_colaborador")
    private StatusColaboradorENUM statusColaborador;

    @OneToOne(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private ColaboradorEndereco colaboradorEndereco;

    @OneToMany(mappedBy = "colaborador")
    private List<ColaboradorCargo> listaColaboradorCargo;

}
