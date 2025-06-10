package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.model;

import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa_sistema")
public class EmpresaSistema extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "key_sistema")
    private SistemaENUM keySistema;
}
