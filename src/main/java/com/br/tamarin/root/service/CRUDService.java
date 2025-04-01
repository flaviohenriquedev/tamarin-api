package com.br.tamarin.root.service;

import com.br.tamarin.root.model.EntidadePadrao;

import java.io.Serializable;
import java.util.List;

public interface CRUDService<E extends EntidadePadrao, ID extends Serializable> {

    List<E> findAll();
}
