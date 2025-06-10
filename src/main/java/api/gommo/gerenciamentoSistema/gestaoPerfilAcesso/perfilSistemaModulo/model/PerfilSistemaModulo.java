package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistemaModulo.model;

import api.gommo._root.comum.enums.FuncionalidadeENUM;
import api.gommo._root.comum.enums.ModuloENUM;
import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.model.PerfilSistema;
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
@Table(name = "perfil_sistema_modulo")
public class PerfilSistemaModulo extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_perfil_sistema")
    private PerfilSistema perfilSistema;

    @Enumerated(EnumType.STRING)
    private ModuloENUM modulo;

    @Enumerated(EnumType.STRING)
    private List<FuncionalidadeENUM> funcionalidades;
}
