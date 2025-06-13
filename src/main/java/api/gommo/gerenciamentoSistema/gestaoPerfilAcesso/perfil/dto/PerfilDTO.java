package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto;

import api.gommo._root.comum.dto.EntidadeTenantDTO;
import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilModulo.dto.PerfilModuloDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilDTO extends EntidadeTenantDTO {
    private String descricao;
    private SistemaENUM sistema;
    private List<PerfilModuloDTO> perfilModulos = new ArrayList<>();
}
