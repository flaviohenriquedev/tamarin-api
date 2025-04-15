package api.tamarin._root.comum.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAuditavel extends EntidadePadrao {

    @Column(name = "data_criacao", updatable = false)
    Date dataCriacao;

    @Column(name = "usuario_criacao", updatable = false)
    String usuarioCriacao;

    @Column(name = "data_alteracao")
    Date dataAlteracao;

    @Column(name = "usuario_alteracao")
    String usuarioAlteracao;

    @PrePersist
    public void prePersist() {
        if (dataCriacao == null) {
            dataCriacao = new Date();
        }

        if (usuarioCriacao == null) {
            usuarioCriacao = "FLAVIO HENRIQUE MOREIRA ROSA";
        }
    }
}
