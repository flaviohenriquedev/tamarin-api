package api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfil.dto;

import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import api.gommo.gerenciamentoSistema.gestaoPerfilAcesso.perfilSistema.dto.PerfilSistemaDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PerfilRegisterDTO {
    private EmpresaDTO cliente;
    private String descricao;
    private List<PerfilSistemaDTO> sistemas;
}
