package com.br.tamarin.root.impl;

import com.br.tamarin.root.interfaces.Service;
import com.br.tamarin.root.model.EntidadePadrao;

import java.io.Serializable;
import java.util.List;

public abstract class ServiceImpl<E extends EntidadePadrao> implements Service<E> {

    @Override
    public List<E> listar() {
        return List.of();
    }

    @Override
    public E buscarPorId(Serializable id) {
        return null;
    }

    @Override
    public void salvar(E entidade) {

    }

    @Override
    public void atualizar(E entidade) {

    }

    @Override
    public void deletar(E entidade) {

    }


}
