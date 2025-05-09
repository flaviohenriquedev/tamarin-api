package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistema.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioClienteSistemaPerfil.model.UsuarioClienteSistemaPerfil;
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
@Table(name = "usuario_cliente_sistema")
public class UsuarioClienteSistema extends EntidadePadrao {
    @JoinColumn
    @ManyToOne
    UsuarioCliente usuarioCliente;
    String sistema;
    String role;

    @OneToMany(mappedBy = "usuarioClienteSistema", cascade = CascadeType.ALL, orphanRemoval = true)
    List<UsuarioClienteSistemaPerfil> perfis;
}
