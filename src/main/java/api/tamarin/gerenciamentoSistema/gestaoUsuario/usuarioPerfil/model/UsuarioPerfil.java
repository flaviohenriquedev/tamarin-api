package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_perfil")
public class UsuarioPerfil extends EntidadeAuditavel {

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;

    @JoinColumn(name = "id_perfil")
    @OneToOne(cascade = CascadeType.ALL)
    private Perfil perfil;

}
