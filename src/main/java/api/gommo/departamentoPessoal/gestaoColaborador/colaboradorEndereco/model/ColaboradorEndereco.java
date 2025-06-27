package api.gommo.departamentoPessoal.gestaoColaborador.colaboradorEndereco.model;

import api.gommo._root.comum.model.EntidadePadrao;
import api.gommo._root.comum.serializer.impl.IDSerializer;
import api.gommo.gerenciamentoSistema.gestaoLocalidade.cidade.model.Cidade;
import api.gommo.departamentoPessoal.gestaoColaborador.colaborador.model.Colaborador;
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
@Table(name = "colaborador_endereco")
public class ColaboradorEndereco extends EntidadePadrao {

    @OneToOne
    @JoinColumn(name = "id_colaborador")
    private Colaborador colaborador;

    private String cep;
    private String rua;
    private String complemento;
    private String numero;
    private String bairro;

    @JoinColumn(name = "id_cidade")
    @ManyToOne(fetch = FetchType.LAZY)
    private Cidade cidade;

}

