package api.tamarin._root.comum.enums;

import lombok.Getter;
import lombok.NonNull;

@Getter
public enum Status {

    INATIVO("INATIVO"),
    ATIVO("ATIVO"),
    DELETADO("DELETADO");

    @NonNull
    private final String messageKey;

    Status(@NonNull String messageKey) {
        this.messageKey = messageKey;
    }
}