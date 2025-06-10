package api.gommo.departamentoPessoal.administracao.cargo.model;

import api.gommo._root.comum.model.EntidadeTenant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cargo")
public class Cargo extends EntidadeTenant {
    private String descricao;
}
