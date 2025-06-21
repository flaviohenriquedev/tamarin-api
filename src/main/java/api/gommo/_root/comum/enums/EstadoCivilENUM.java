package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@AllArgsConstructor
@Getter
public enum EstadoCivilENUM {
    SOLTEIRO("SOLTEIRO"),
    CASADO("CASADO"),
    DIVORCIADO("DIVORCIADO"),
    VIUVO("VIUVO"),
    SEPARADO("SEPARADO");

    @NonNull
    private final String value;
}
