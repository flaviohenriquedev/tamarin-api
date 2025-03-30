package com.br.tamarin.root.controller;

import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
public abstract class CrudController<E extends EntidadePadrao, ID extends Serializable> {

    @Autowired
    private CrudService<E, ID> service;

    @GetMapping
    public List<E> list() {
        return service.listar();
    }

}
