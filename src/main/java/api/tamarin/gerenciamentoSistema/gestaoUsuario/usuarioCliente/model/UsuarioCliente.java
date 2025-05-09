package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model.UsuarioClienteSistema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_cliente")
public class UsuarioCliente extends EntidadeCliente {

    @JoinColumn
    @ManyToOne
    Usuario usuario;

    @OneToMany(mappedBy = "usuarioCliente", cascade = CascadeType.ALL, orphanRemoval = true)
    List<UsuarioClienteSistema> sistemas;
}
