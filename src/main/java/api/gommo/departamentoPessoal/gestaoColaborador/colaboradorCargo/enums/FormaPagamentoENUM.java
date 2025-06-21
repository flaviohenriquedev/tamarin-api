package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum FormaPagamentoENUM {
    MENSAL("MENSAL"),
    SEMANAL("SEMANAL"),
    DIARIO("DIARIO");

    @NonNull
    private final String value;
}
