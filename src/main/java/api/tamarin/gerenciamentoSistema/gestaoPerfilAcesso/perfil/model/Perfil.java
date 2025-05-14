package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil")
public class Perfil extends EntidadeCliente {

    @Column(nullable = false)
    String descricao;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PerfilSistema> sistemas;
}
