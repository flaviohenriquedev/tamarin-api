package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.dto.UsuarioClienteDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.dto.UsuarioPerfilDTO;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO extends EntidadeDTO {
    private String nome;
    private String email;
    private String cpf;
    private String token;
    private String linkFotoPerfil;
    private String perfil;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioENUM statusUsuario;

    private Boolean usuarioMaster = Boolean.FALSE;

    private List<UsuarioPerfilDTO> listaPerfil = new ArrayList<>();
    private List<UsuarioClienteDTO> clientes = new ArrayList<>();
}
