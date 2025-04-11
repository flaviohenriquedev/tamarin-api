package api.tamarin._root.comum.model;

import api.tamarin.cliente.model.Cliente;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeCliente extends EntidadePadrao{
    @JoinColumn
    @OneToOne
    Cliente cliente;
}
