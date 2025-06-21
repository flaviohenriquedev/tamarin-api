package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum SistemaENUM {
    GERENCIAR_SISTEMA("GERENCIAR_SISTEMA", "GS"),
    DEPARTAMENTO_PESSOAL("DEPARTAMENTO_PESSOAL", "DP"),
    RECURSOS_HUMANOS("RECURSOS_HUMANOS", "RH");

    @NonNull
    private String value;

    @NonNull
    private String sigla;
}
