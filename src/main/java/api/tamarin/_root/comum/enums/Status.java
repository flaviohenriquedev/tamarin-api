package api.tamarin._root.comum.enums;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status {
    INATIVO("geral.inativo", false),
    ATIVO("geral.ativo", true);

    @NonNull
    private String messageKey;

    @NonNull
    private boolean ativo;
}
