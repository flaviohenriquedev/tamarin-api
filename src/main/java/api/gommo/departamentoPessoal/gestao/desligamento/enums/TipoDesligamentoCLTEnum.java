package api.gommo.departamentoPessoal.gestao.desligamento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum TipoDesligamentoCLTEnum {

    DEMISSAO_SEM_JUSTA_CAUSA_PELO_EMPREGADOR("Demissão sem justa causa pelo empregador"),
    DEMISSAO_COM_JUSTA_CAUSA_PELO_EMPREGADOR("Demissão com justa causa pelo empregador"),
    PEDIDO_DE_DEMISSAO_PELO_EMPREGADO("Pedido de demissão pelo empregado"),
    ACORDO_RESCISAO("Acordo entre empregado e empregador (Art. 484-A da CLT)"),
    TERMINO_CONTRATO_PRAZO_DETERMINADO("Término de contrato por prazo determinado"),
    RESCISAO_INDIRETA("Rescisão indireta (falta grave do empregador)"),
    MORTE_EMPREGADO("Morte do empregado"),
    APOSENTADORIA("Aposentadoria do empregado"),
    FORCA_MAIOR("Extinção do contrato por força maior (Art. 501 a 504 da CLT)"),
    CULPA_RECIPROCA("Rescisão por culpa recíproca"),
    EXTINCAO_EMPRESA("Extinção da empresa ou encerramento das atividades"),
    JUSTICA_TRABALHISTA_SENTENCA("Rescisão por decisão judicial");

    @NonNull
    private final String descricao;
}
