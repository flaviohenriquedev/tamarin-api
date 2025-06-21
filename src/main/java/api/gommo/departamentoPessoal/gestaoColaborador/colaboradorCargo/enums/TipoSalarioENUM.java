package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorCargo.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum TipoSalarioENUM {
    MENSALISTA("MENSALISTA"),
    HORISTA("HORISTA"),
    DIARIA("DIARIA");

    @NonNull
    private final String value;
}
