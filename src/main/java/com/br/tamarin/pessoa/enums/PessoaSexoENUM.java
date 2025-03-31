package com.br.tamarin.pessoa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public enum PessoaSexoENUM {

    F("F", "Feminino"),
    M("M", "Masculino");

    @NonNull
    private String sigla;
    private String descricao;
}
