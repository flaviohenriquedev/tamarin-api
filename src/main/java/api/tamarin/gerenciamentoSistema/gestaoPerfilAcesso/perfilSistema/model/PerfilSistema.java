package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.serializer.impl.IDSerializer;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
import api.tamarin.gerenciamentoSistema.gestaoCliente.clienteSistema.model.ClienteSistema;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
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
@Table(name = "perfil_sistema")
public class PerfilSistema extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @ManyToOne
    @JoinColumn(name = "id_cliente_sistema")
    private ClienteSistema clienteSistema;

    @OneToMany(mappedBy = "perfilSistema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerfilSistemaModulo> rotas;
}
