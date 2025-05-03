package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums;

import lombok.*;

@Getter
@RequiredArgsConstructor
public enum RoleUsuarioENUM {

    MASTER("MASTER", "Master"),
    ADMIN("ADMIN", "Administrador"),
    USER("USER", "Usuário");

    @NonNull
    private String role;

    @NonNull
    private String descricao;
}
