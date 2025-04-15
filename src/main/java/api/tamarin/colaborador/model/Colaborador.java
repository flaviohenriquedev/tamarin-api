package api.tamarin.colaborador.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "colaborador")
public class Colaborador extends EntidadeCliente {

    @Column(name = "nome_completo", nullable = false)
    String nomeCompleto;

    @Column(nullable = false, unique = true, length = 14)
    String cpf;

    @Column(name = "nome_social")
    String nomeSocial;

    @Column(name = "data_nascimento")
    LocalDate dataNascimento;

    @Column(length = 1)
    String sexo;

    @Column(unique = true)
    String email;

    String telefone;

    String endereco;

    String cargo;

    String departamento;

    @Column(name = "data_admissao")
    LocalDate dataAdmissao;

    @Column(name = "data_demissao")
    LocalDate dataDemissao;

    BigDecimal salario;

    @Column(name = "tipo_contrato")
    String tipoContrato;

    String observacoes;
}
