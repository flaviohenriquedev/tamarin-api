package api.tamarin._root.comum.controller;

import api.tamarin._root.comum.dto.EntidadePadraoDTO;
import api.tamarin._root.comum.service.DefaultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class DefaultController<D extends EntidadePadraoDTO> {

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
    public ResponseEntity<Boolean> deletar(@PathVariable UUID id) {
        try {
            getService().deletar(id);
            return new ResponseEntity<>(true, HttpStatus.OK);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }
    }
}
