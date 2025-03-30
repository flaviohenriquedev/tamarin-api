package com.br.tamarin.root.repository;

import com.br.tamarin.root.model.EntidadePadrao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

public interface CrudRepository<E extends EntidadePadrao, ID extends Serializable> extends JpaRepository<E, ID> {
}
