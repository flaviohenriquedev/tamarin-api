package com.br.tamarin.root.interfaces;

import com.br.tamarin.root.model.EntidadePadrao;

import java.util.List;

public abstract interface Repository<E extends EntidadePadrao> {

    List<E> listar();

}
