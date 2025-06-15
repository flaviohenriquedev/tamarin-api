package api.gommo._root.comum.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeAuditavel extends EntidadePadrao {

    @Column(name = "data_criacao", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "usuario_criacao", updatable = false)
    private String usuarioCriacao;

    @Column(name = "data_alteracao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAlteracao;

    @Column(name = "usuario_alteracao")
    private String usuarioAlteracao;
}
