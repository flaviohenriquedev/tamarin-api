package api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model;

import api.gommo._root.comum.model.EntidadeCliente;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuario_cliente")
public class UsuarioCliente extends EntidadeCliente {
    @JoinColumn(name = "id_usuario")
    @ManyToOne
    private Usuario usuario;
}
