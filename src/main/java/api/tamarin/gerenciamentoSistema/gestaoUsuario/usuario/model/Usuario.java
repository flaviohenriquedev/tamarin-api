package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.RoleUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @Column(name = "usuario_master")
    Boolean usuarioMaster;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    List<UsuarioCliente> clientes;
}
