package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.RoleUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
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
    String nome;
    String email;
    String cpf;
    @JsonIgnore
    String senha;
    String token;
    String linkFotoPerfil;
    String perfil;
    @Enumerated(EnumType.STRING)
    StatusUsuarioENUM statusUsuario;
    RoleUsuarioENUM role;
    Boolean usuarioMaster;
}
