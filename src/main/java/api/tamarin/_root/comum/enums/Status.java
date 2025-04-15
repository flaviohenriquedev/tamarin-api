package api.tamarin._root.comum.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    INATIVO("INATIVO"),
    ATIVO("ATIVO"),
    DELETADO("DELETADO");

    @NonNull
    private String messageKey;
}
