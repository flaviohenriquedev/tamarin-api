package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum FuncionalidadeENUM {
    SOMENTE_LEITURA("SOMENTE_LEITURA"),
    MANIPULAR_CADASTRO("MANIPULAR_CADASTRO"),
    CONSULTAR_TESTE("CONSULTAR_TESTE");

    @NonNull
    private String key;
}
