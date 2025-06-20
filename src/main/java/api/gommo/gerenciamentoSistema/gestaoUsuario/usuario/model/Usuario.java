package api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.model;

import api.gommo._root.comum.model.EntidadeAuditavel;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuario.enums.StatusUsuarioENUM;
import api.gommo.gerenciamentoSistema.gestaoUsuario.usuarioPerfil.model.UsuarioPerfil;
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

    @Enumerated(EnumType.STRING)
    private StatusUsuarioENUM statusUsuario;

    @Column(name = "usuario_master", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean usuarioMaster = Boolean.FALSE;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UsuarioPerfil> perfis = new ArrayList<>();

}
