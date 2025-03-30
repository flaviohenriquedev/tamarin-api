package com.br.tamarin.root.service;

import com.br.tamarin.root.model.EntidadePadrao;
import com.br.tamarin.root.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class CrudService<E extends EntidadePadrao, ID extends Serializable> {

    @Autowired
    private CrudRepository<E, ID> repository;

    public List<E> listar() {
        return repository.findAll();
    }
}
