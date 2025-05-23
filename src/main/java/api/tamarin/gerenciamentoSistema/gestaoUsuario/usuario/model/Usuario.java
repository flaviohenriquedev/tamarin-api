package api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioCliente.model.UsuarioCliente;
import api.tamarin.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario extends EntidadeAuditavel {

    private String nome;
    private String email;
    private String cpf;
    private String senha;
    private String token;
    private String linkFotoPerfil;
    private String perfil;

    @Enumerated(EnumType.STRING)
    private StatusUsuarioENUM statusUsuario;

    @Column(name = "usuario_master", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean usuarioMaster = Boolean.FALSE;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioPerfil> listaPerfil = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioCliente> clientes = new ArrayList<>();

}
