package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model;

import api.gommo._root.comum.model.EntidadeSistema;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.model.PerfilModulo;
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
public class Perfil extends EntidadeSistema {

    @Column(nullable = false)
    private String descricao;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerfilModulo> perfilModulos;
}
