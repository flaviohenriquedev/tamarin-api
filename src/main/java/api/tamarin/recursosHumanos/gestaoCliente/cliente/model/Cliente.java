package api.tamarin.recursosHumanos.gestaoCliente.cliente.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente extends EntidadeAuditavel {
    String nome;
}
