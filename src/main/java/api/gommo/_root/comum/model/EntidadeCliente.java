package api.gommo._root.comum.model;

import api.gommo.gerenciamentoSistema.gestaoCliente.cliente.model.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeCliente extends EntidadeAuditavel {

    @JoinColumn(name = "id_cliente", nullable = false)
    @ManyToOne
    Cliente cliente;
}
