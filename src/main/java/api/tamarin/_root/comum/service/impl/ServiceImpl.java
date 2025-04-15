package api.tamarin._root.comum.service.impl;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public abstract class ServiceImpl<E extends EntidadePadrao> implements Service<E> {

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public ResponseEntity salvar(E entidade) {
        getRepository().save(entidade);
        return ResponseEntity.ok().build();
    }

    protected abstract JpaRepository<E, UUID> getRepository();
}
