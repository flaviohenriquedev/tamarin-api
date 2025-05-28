package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador")
public class Colaborador extends EntidadeCliente {

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "data_admissao")
    private Date dataAdmissao;

    @Column(name = "data_demissao")
    private Date dataDemissao;

    @Column(name = "tipo_contrato")
    private String tipoContrato;

    private String cpf;
    private String sexo;
    private String email;
    private String telefone;
    private String endereco;
    private String cargo;
    private String departamento;
    private BigDecimal salario;
    private String observacoes;

}
