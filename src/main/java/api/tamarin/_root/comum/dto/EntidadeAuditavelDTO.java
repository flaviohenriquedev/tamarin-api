package api.tamarin._root.comum.dto;

import api.tamarin._root.comum.model.EntidadePadrao;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadeAuditavelDTO<E extends EntidadePadrao> {
    Date dataCriacao;
    String usuarioCriacao;
    Date dataAlteracao;
    String usuarioAlteracao;
}
