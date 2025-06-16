package api.gommo._root.comum.dto;

import api.gommo._root.comum.enums.StatusENUM;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadePadraoDTO {

    private UUID id;

    @Enumerated(EnumType.STRING)
    private StatusENUM status;

    public boolean isNew() {
        return Objects.isNull(id);
    }
}
