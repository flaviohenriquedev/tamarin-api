package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.serializer.impl.IDSerializer;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "perfil_sistema_modulo")
public class PerfilSistemaModulo extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_perfil_sistema")
    private PerfilSistema perfilSistema;

    private String modulo;
    private List<String> roles;
}
