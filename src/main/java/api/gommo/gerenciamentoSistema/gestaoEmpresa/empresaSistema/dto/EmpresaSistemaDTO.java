package api.gommo.gerenciamentoSistema.gestaoEmpresa.empresaSistema.dto;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaSistemaDTO extends EntidadePadraoDTO {
    @JsonIgnore
    private EmpresaDTO empresa;
    private SistemaENUM keySistema;
}
