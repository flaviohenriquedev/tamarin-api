package api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaborador.enums.StatusColaboradorENUM;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorCargo.model.ColaboradorCargo;
import api.tamarin.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model.ColaboradorEndereco;
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
public class Colaborador extends EntidadeCliente {

    @Column(name = "nome_completo")
    private String nomeCompleto;

    private String cpf;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    private String nascionalidade;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_colaborador")
    private StatusColaboradorENUM statusColaborador;

    @OneToOne(mappedBy = "colaborador", orphanRemoval = true, fetch = FetchType.EAGER)
    private ColaboradorEndereco colaboradorEndereco;

    @OneToMany(mappedBy = "colaborador", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<ColaboradorCargo> listaColaboradorCargo;

}
