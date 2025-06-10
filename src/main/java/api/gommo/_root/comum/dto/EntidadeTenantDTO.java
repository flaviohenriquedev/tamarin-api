package api.gommo._root.comum.dto;

import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntidadeTenantDTO extends EntidadeAuditavelDTO {
    private EmpresaDTO cliente;
}
