package api.tamarin._root.comum.repository;

import api.tamarin._root.comum.model.EntidadePadrao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CRUDRepository<E extends EntidadePadrao, ID extends Serializable> extends JpaRepository<E, ID> {
}
