package api.gommo._root.comum.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class EntidadeAuditavelDTO extends EntidadePadraoDTO {
    private Date dataCriacao;
    private String usuarioCriacao;
    private Date dataAlteracao;
    private String usuarioAlteracao;
}
