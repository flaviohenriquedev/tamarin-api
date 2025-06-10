package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum SistemaENUM {
    GERENCIAMENTO_SISTEMA("GERENCIAMENTO_SISTEMA", "GS"),
    DEPARTAMENTO_PESSOAL("DEPARTAMENTO_PESSOAL", "DP"),
    RECURSOS_HUMANOS("RECURSOS_HUMANOS", "RH");

    @NonNull
    private String key;

    @NonNull
    private String sigla;
}
