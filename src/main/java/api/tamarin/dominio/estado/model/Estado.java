package api.tamarin.dominio.estado.model;

import api.tamarin._root._infra.converter.DddListConverter;
import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.dominio.pais.model.Pais;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "estado")
public class Estado extends EntidadePadrao {

    @Column(length = 60)
    String nome;

    @Column(name = "uf", length = 2)
    String sigla;

    Integer ibge;

    @ManyToOne
    @JoinColumn(name = "pais")
    Pais pais;

    @Convert(converter = DddListConverter.class)
    @Column(columnDefinition = "json")
    List<Integer> ddd;
}