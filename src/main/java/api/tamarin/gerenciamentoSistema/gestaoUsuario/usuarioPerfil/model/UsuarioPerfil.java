package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "usuario_perfil")
public class UsuarioPerfil extends EntidadeAuditavel {

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    Usuario usuario;
    String descricao;

}
