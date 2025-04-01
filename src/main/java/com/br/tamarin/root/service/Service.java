package com.br.tamarin.root.service;

import com.br.tamarin.root.model.EntidadePadrao;

import java.util.List;

public interface Service<E extends EntidadePadrao> {
    List<E> findAll();

    void salvar(E entidade);
}
