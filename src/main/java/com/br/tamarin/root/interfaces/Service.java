package com.br.tamarin.root.interfaces;

import com.br.tamarin.root.model.EntidadePadrao;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public interface Service<E extends EntidadePadrao> {

    List<E> listar();

    E buscarPorId(@PathVariable Serializable id);

    void salvar(@RequestBody E entidade);

    void atualizar(@RequestBody E entidade);

    void deletar(@RequestBody E entidade);

}
