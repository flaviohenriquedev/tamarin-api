package api.tamarin._root.comum.controller;

import api.tamarin._root.comum.model.EntidadeAuditavel;
import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.service.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public abstract class CRUDController<E extends EntidadePadrao> {

    @GetMapping
    public List<E> findAll() {
        return getService().findAll();
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody E entidade) {
        return getService().salvar(entidade);
    }

    protected abstract Service<E> getService();

}
