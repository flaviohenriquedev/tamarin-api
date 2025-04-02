package com.br.tamarin.usuario.entity;

import com.br.tamarin.root.model.EntidadePadrao;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadePadrao {
    String nome;
    String email;
    String cpf;
    String senha;
    String token;
}
