package api.tamarin._root.comum.controller;

import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.service.DefaultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class DefaultController<E extends EntidadePadrao> {

    @GetMapping
    public List<E> findAll() {
        return getService().findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody E entidade) {
        return getService().salvar(entidade);
    }

    protected abstract DefaultService<E> getService();

}
