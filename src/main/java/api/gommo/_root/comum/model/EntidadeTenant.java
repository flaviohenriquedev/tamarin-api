package api.gommo._root.comum.model;

import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.model.Empresa;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
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
@FilterDef(name = "tenantFilter", parameters = @ParamDef(name = "tenantId", type = UUID.class))
@Filters(@Filter(name = "tenantFilter", condition = "tenant_id = :tenantId"))
public abstract class EntidadeTenant extends EntidadeAuditavel {

    @JoinColumn(name = "tenant_id", nullable = false)
    @ManyToOne
    private Empresa empresaTenant;
}
