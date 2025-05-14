package api.tamarin._root.comum.service;

import java.util.List;
import java.util.UUID;

public interface DefaultService<D> {
    D findById(UUID id);
    List<D> findAll();
    D save(D dto);
    D update(UUID id, D dto);
    void delete(UUID id);
}
