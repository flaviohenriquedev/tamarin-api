package api.tamarin.departamentoPessoal.administracao.cargaHoraria.model;

import api.tamarin._root.comum.model.EntidadeCliente;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "carga_horaria")
public class CargaHoraria extends EntidadeCliente {

    private Integer horaInicial;
    private Integer horaFinal;
    private Integer horaAlmoco;
    private String descricao;

    @PrePersist
    @PreUpdate
    public void atualizarDescricao() {
        if (horaInicial != null && horaFinal != null && horaAlmoco != null) {
            String horaIni = String.format("%02d:00", horaInicial);
            String horaFim = String.format("%02d:00", horaFinal);
            String almoco = String.format("%d hora%s de almoço", horaAlmoco, horaAlmoco != 1 ? "s" : "");

            this.descricao = String.format("Das %s às %s com %s", horaIni, horaFim, almoco);
        }
    }

    @Override
    public String toString() {
        return descricao != null ? descricao : "Carga Horária sem descrição";
    }
}
