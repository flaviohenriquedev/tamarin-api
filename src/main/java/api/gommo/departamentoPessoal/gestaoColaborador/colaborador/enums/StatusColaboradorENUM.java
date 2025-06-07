package api.gommo.departamentoPessoal.gestaoColaborador.colaborador.enums;

import lombok.Getter;
import lombok.NonNull;

@Getter
public enum StatusColaboradorENUM {
    ATIVO("ATIVO"),
    INATIVO("INATIVO"),
    FERIAS("FERIAS"),
    AFASTADO("AFASTADO"),
    DESLIGADO("DESLIGADO");

    @NonNull
    private final String messageKey;

    StatusColaboradorENUM(@NonNull String messageKey) {
        this.messageKey = messageKey;
    }
}
