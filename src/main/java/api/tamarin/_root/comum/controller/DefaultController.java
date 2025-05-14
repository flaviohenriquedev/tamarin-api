package api.tamarin._root.comum.controller;

import api.tamarin._root.comum.service.DefaultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class DefaultController<D> {

    protected abstract DefaultService<D> getService();

    @GetMapping("/{id}")
    public D findById(@PathVariable UUID id) {
        return getService().findById(id);
    }

    @GetMapping
    public List<D> findAll() {
        return getService().findAll();
    }

    @PostMapping
    public D save(@RequestBody D dto) {
        return getService().save(dto);
    }

    @PutMapping("/{id}")
    public D update(@PathVariable UUID id, @RequestBody D dto) {
        return getService().update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        getService().delete(id);
    }
}
