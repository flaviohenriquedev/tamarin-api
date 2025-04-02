package com.br.tamarin.root.service.impl;

import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.repository.CRUDRepository;
import com.br.tamarin.root.service.Service;

import java.util.List;
import java.util.UUID;

public abstract class ServiceImpl<E extends EntidadePadrao> implements Service<E> {

    @Override
    public List<E> findAll() {
        return getRepository().findAll();
    }

    @Override
    public E salvar(E entidade) {
        return getRepository().save(entidade);
    }

    protected abstract CRUDRepository<E, UUID> getRepository();
}
