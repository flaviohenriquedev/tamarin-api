package com.br.tamarin.root.controller;

import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;
import java.util.List;

public abstract class CRUDController<E extends EntidadePadrao, ID extends Serializable> {

    @GetMapping
    public List<E> findAll() {
        return getService().findAll();
    }

    @PostMapping
    public void salvar(@RequestBody E entidade) {
        getService().salvar(entidade);
    }

    protected abstract Service<E> getService();

}
