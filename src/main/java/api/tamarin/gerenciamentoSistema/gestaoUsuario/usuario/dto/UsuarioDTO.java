package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.dto;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class UsuarioDTO extends EntidadeDTO {
    private String nome;
    private String email;
    private String cpf;
    private String token;
    private String linkFotoPerfil;
    private String perfil;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioENUM statusUsuario;

    private Boolean usuarioMaster;
}
