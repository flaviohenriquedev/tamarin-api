package api.tamarin.recursosHumanos.gestaoColaborador.colaborador.dto;

import api.tamarin._root.comum.dto.EntidadeClienteDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ColaboradorDTO extends EntidadeClienteDTO {
    private String nomeCompleto;
    private Date dataNascimento;
    private Date dataAdmissao;
    private Date dataDemissao;
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
