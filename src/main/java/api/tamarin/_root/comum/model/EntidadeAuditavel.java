package api.tamarin._root.comum.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAuditavel extends EntidadePadrao {

    @Column(name = "data_criacao", updatable = false)
    private Date dataCriacao;

    @Column(name = "usuario_criacao", updatable = false)
    private String usuarioCriacao;

    @Column(name = "data_alteracao")
    private Date dataAlteracao;

    @Column(name = "usuario_alteracao")
    private String usuarioAlteracao;

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
