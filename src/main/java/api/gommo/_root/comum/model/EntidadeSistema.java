package api.gommo._root.comum.model;

import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
@FilterDef(name = "sistemaFilter", parameters = @ParamDef(name = "sistema", type = String.class))
@Filters(@Filter(name = "sistemaFilter", condition = "sistema = :sistema"))
public abstract class EntidadeSistema extends EntidadeTenant {

    @Enumerated(EnumType.STRING)
    @Column(name = "sistema", nullable = false)
    private SistemaENUM sistema;
}
