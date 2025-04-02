package com.br.tamarin.root.service;

import com.br.tamarin.root.model.EntidadePadrao;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Service<E extends EntidadePadrao> {
    List<E> findAll();

    E salvar(E entidade);
}
