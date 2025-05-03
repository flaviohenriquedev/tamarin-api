package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model;

import api.tamarin._root.comum.model.EntidadeCliente;
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
@Table(name = "usuario_cliente")
public class UsuarioCliente extends EntidadeCliente {

    @JoinColumn(name = "id_usuario")
    @ManyToOne
    Usuario usuario;
}
