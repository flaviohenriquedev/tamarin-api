package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
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
public class Perfil extends EntidadeTenant {

    @Column(nullable = false)
    String descricao;

    @OneToMany(mappedBy = "perfil", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PerfilSistema> sistemas;
}
