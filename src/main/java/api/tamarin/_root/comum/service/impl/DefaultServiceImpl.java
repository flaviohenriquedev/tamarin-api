package api.tamarin._root.comum.service.impl;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.service.DefaultService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public abstract class DefaultServiceImpl<E extends EntidadePadrao> implements DefaultService<E> {

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public E findById(UUID id) {
        return getRepository().findById(id).orElse(null);
    }

    @Override
    public E salvar(E entidade) {
        return getRepository().save(entidade);
    }

    protected abstract JpaRepository<E, UUID> getRepository();
}
