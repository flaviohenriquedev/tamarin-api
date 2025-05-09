package api.tamarin._root.comum.service;

import api.tamarin._root.comum.model.EntidadePadrao;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface DefaultService<E extends EntidadePadrao> {
    List<E> findAll();
    E findById(UUID id);
    E salvar(E entidade);
}
