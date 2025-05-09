package api.tamarin.gerenciamentoSistema.gestaoPerfilAcesso.perfil.model;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin.recursosHumanos.gestaoCliente.clienteSistema.model.ClienteSistema;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil")
public class Perfil extends EntidadeAuditavel {

    @JoinColumn(name = "id_cliente_sistema")
    @ManyToOne
    ClienteSistema clienteSistema;

    String descricao;
    List<String> rotas;
}
