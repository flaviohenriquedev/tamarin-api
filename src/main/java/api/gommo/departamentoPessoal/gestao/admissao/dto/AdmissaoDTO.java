package api.gommo.departamentoPessoal.gestao.admissao.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo.departamentoPessoal.administracao.cargaHoraria.dto.CargaHorariaDTO;
import api.gommo.departamentoPessoal.administracao.cargo.dto.CargoDTO;
import api.gommo.departamentoPessoal.administracao.departamento.dto.DepartamentoDTO;
import api.gommo.departamentoPessoal.administracao.tipoContrato.dto.TipoContratoDTO;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.dto.CidadeDTO;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.dto.ColaboradorDTO;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissaoDTO extends EntidadeTenantDTO {
    private String nomeCompleto;
    private String cpf;
    private String rg;

    private LocalDate dataNascimento;
    private String nascionalidade;
    private String nomeMae;
    private String rua;
    private String quadra;
    private String lote;
    private String numero;
    private String bairro;
    public BigDecimal salario;

    public LocalDate  dataAdmissao;
    private CidadeDTO cidade;
    private CargoDTO cargo;
    private TipoContratoDTO tipoContrato;
    private CargaHorariaDTO cargaHoraria;
    private DepartamentoDTO departamento;
    private ColaboradorDTO colaborador;

    private Integer quantidadeDiasExperiencia;
    private LocalDate dataExperiencia;
    private Integer quantidadeDiasProrrogacao;
    private LocalDate dataProrrogacao;
}
