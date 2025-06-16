package api.gommo.departamentoPessoal.administracao.departamento.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.departamentoPessoal.administracao.setor.model.Setor;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departamento")
public class Departamento extends EntidadeTenant {
    private String descricao;
}
