package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "usuario_cliente_sistema")
public class UsuarioClienteSistema extends EntidadePadrao {
    @JoinColumn
    @ManyToOne
    UsuarioCliente usuarioCliente;
    List<String> sistemas;
}
