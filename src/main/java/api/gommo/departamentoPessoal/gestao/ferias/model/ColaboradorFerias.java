package api.gommo.departamentoPessoal.gestao.ferias.model;

import api.gommo._root.comum.model.EntidadeTenant;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "colaborador_ferias")
public class ColaboradorFerias extends EntidadeTenant {

    @JoinColumn(name = "id_colaborador")
    @ManyToOne
    private Colaborador colaborador;

    private LocalDate periodoInicial;
    private LocalDate periodoFinal;
    private String observacoes;
}
