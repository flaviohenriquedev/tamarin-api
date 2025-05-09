package api.tamarin._root.comum.dto;

import api.tamarin._root.comum.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntidadePadraoDTO {
    UUID id;
    Status status;
}
