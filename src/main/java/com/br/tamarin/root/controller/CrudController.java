package com.br.tamarin.root.controller;

import com.br.tamarin.root.interfaces.Service;
import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class CrudController<E extends EntidadePadrao, ID extends Serializable> {

    @GetMapping
    public List<E> listar() {
        return getService().listar();
    }

    @GetMapping("/{id}")
    public E buscarPorId(@PathVariable ID id) {
        return getService().buscarPorId(id);
    }

    @PostMapping
    public void salvar(@RequestBody E entidade) {
        getService().salvar(entidade);
    }

    @PutMapping
    public void atualizar(@RequestBody E entidade) {
        getService().atualizar(entidade);
    }

    @DeleteMapping
    public void deletar(@RequestBody E entidade) {
        getService().deletar(entidade);
    }

    protected abstract Service<E> getService();

}
