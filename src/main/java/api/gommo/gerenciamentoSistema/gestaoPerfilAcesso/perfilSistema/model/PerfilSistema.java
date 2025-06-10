package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model;

import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model.PerfilSistemaModulo;
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

    @Enumerated(EnumType.STRING)
    @Column(name = "key_sistema")
    private SistemaENUM keySistema;

    @OneToMany(mappedBy = "perfilSistema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PerfilSistemaModulo> rotas;
}
