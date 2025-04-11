package api.tamarin.usuario.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum StatusUsuarioENUM {

    ATIVO("ATIVO"),
    INATIVO("INATIVO"),
    PENDENTE("PENDENTE");

    @NonNull
    private String keyName;
}
