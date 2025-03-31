package com.br.tamarin.root.impl;

import com.br.tamarin.root.interfaces.Repository;
import com.br.tamarin.root.model.EntidadePadrao;

import java.util.List;

public class RepositoryImpl<E extends EntidadePadrao> implements Repository<E> {


    @Override
    public List<E> listar() {
        return List.of();
    }
}
