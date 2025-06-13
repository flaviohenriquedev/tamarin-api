package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.gommo._root.comum.enums.FuncionalidadeENUM;
import api.gommo._root.comum.enums.ModuloENUM;
import api.gommo._root.comum.enums.SistemaENUM;
import api.gommo.gerenciamentoSistema.gestaoEmpresa.empresa.dto.EmpresaDTO;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosAcessoDTO {
    private EmpresaDTO empresa;
    private List<DadosAcessoSistemaDTO> sistemas = new ArrayList<>();

    @Getter
    @Setter
    @Builder
    public static class DadosAcessoSistemaDTO {
        private SistemaENUM sistema;
        private List<DadosAcessoSistemaModuloDTO> modulos;
    }

    @Getter
    @Setter
    @Builder
    public static class DadosAcessoSistemaModuloDTO {
        private ModuloENUM modulo;
        private List<FuncionalidadeENUM> funcionalidades;
    }
}
