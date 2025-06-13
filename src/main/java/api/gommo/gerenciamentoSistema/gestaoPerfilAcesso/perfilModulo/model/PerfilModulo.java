package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.model;

import api.gommo._root.comum.enums.FuncionalidadeENUM;
import api.gommo._root.comum.enums.ModuloENUM;
import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
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
@Table(name = "perfil_modulo")
public class PerfilModulo extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private Perfil perfil;

    @Enumerated(EnumType.STRING)
    private ModuloENUM modulo;

    @Enumerated(EnumType.STRING)
    private List<FuncionalidadeENUM> funcionalidades;
}
