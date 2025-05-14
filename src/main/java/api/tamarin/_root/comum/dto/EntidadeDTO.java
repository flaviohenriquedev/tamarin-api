package api.tamarin._root.comum.dto;

import api.tamarin._root.comum.enums.Status;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeDTO {
    UUID id;
    Status status;
}
