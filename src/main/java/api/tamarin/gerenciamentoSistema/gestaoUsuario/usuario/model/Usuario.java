package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeAuditavel {
    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String token;
    private String linkFotoPerfil;
    private String perfil;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioENUM statusUsuario;

    @Column(name = "usuario_master")
    private Boolean usuarioMaster;
}
