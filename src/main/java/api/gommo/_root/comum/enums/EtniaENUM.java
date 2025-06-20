package api.gommo._root.comum.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum EtniaENUM {
    BRANCA("Branca"),
    PRETA("Preta"),
    PARDA("Parda"),
    AMARELA("Amarela"),
    INDIGENA("Indígena");

    @NonNull
    private final String descricao;
}
