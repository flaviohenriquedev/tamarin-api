package api.gommo.departamentoPessoal.gestao.admissao.dto;

import api.gommo._root.comum.dto.EntidadeClienteDTO;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissaoDTO extends EntidadeClienteDTO {
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
    private CidadeDTO cidade;
    private CargoDTO cargo;
    private TipoContratoDTO tipoContrato;
    private CargaHorariaDTO cargaHoraria;
    private DepartamentoDTO departamento;
    private ColaboradorDTO colaborador;
}
