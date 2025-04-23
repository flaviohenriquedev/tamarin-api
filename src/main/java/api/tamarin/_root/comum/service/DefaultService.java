package api.tamarin._root.comum.service;

import api.tamarin._root.comum.model.EntidadePadrao;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DefaultService<E extends EntidadePadrao> {
    List<E> findAll();

    ResponseEntity salvar(E entidade);
}
