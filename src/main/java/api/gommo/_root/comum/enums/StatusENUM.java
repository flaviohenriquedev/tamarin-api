package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum StatusENUM {

    INATIVO("INATIVO"),
    ATIVO("ATIVO"),
    DELETADO("DELETADO");

    @NonNull
    private String key;
}