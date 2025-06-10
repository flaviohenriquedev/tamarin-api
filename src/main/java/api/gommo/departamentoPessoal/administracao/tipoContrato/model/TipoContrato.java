package api.gommo.departamentoPessoal.administracao.tipoContrato.model;

import api.gommo._root.comum.model.EntidadeTenant;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tipo_contrato")
public class TipoContrato extends EntidadeTenant {
    private String descricao;
}
