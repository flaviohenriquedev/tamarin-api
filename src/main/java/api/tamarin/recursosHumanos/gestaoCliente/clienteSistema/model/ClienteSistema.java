package api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.serializer.impl.IDSerializer;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente_sistema")
public class ClienteSistema extends EntidadePadrao {

    @JsonSerialize(using = IDSerializer.class)
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @Column(name = "key_sistema")
    String keySistema;
}
