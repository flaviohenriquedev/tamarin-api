package com.br.tamarin.pessoa.entity;

import com.br.tamarin.pessoa.enums.PessoaSexoENUM;
import com.br.tamarin.root.model.EntidadePadrao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pessoa")
public class Pessoa extends EntidadePadrao {

    private String nome;
    private String cpf;
    private String rg;
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private PessoaSexoENUM sexo;
}
