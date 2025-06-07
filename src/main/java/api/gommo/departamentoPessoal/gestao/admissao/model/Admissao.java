package api.gommo.departamentoPessoal.gestao.admissao.model;

import api.gommo._root.comum.model.EntidadeCliente;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.model.CargaHoraria;
import api.gommo.departamentoPessoal.administracao.cargo.model.Cargo;
import api.gommo.departamentoPessoal.administracao.departamento.model.Departamento;
import api.gommo.departamentoPessoal.administracao.tipoContrato.model.TipoContrato;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admissao")
public class Admissao extends EntidadeCliente {
    private String nomeCompleto;
    private String cpf;
    private Date dataNascimento;
    private String nascionalidade;
    private String nomeMae;
    private String rua;
    private String quadra;
    private String lote;
    private String numero;
    private String bairro;
    public BigDecimal salario;
    public Timestamp dataAdmissao;

    @JoinColumn(name = "id_cidade")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

}
