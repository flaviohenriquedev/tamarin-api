package api.tamarin._root.comum.controller;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin._root.comum.service.DefaultService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class DefaultController<D extends EntidadeDTO> {

    protected abstract DefaultService<D> getService();

    @GetMapping("/{id}")
    public D buscarPorId(@PathVariable UUID id) {
        return getService().buscarPorId(id);
    }

    @GetMapping
    public List<D> listar() {
        return getService().listar();
    }

    @PostMapping
    public D salvar(@RequestBody D dto) {
        return getService().salvar(dto);
    }

    @PutMapping("/{id}")
    public D alterar(@PathVariable UUID id, @RequestBody D dto) {
        return getService().alterar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable UUID id) {
        getService().deletar(id);
    }
}
