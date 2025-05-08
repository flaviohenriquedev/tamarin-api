package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model.Perfil;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
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
@Table(name = "usuario_cliente_sistema_perfil")
public class UsuarioClienteSistemaPerfil extends EntidadePadrao {

    @JoinColumn
    @ManyToOne
    UsuarioClienteSistema usuarioClienteSistema;

    @JoinColumn
    @ManyToOne
    Perfil perfil;
}
