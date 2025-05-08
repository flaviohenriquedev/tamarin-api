package api.tamarin._root.comum.controller;

import api.tamarin._root._infra.service.ClienteContextService;
import api.tamarin._root.comum.model.EntidadeCliente;
import api.tamarin._root.comum.model.EntidadePadrao;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.model.Cliente;
import api.tamarin.recursosHumanos.gestaoCliente.cliente.repository.ClienteRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public abstract class DefaultController<E extends EntidadePadrao> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ClienteContextService clienteContextService;

    @GetMapping
    public List<E> findAll() {
        return getService().findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")
    public E findById(@PathVariable("id") UUID id) {
        return getService().findById(id);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody E entidade) {
        if (entidade instanceof EntidadeCliente entidadeCliente) {
            String clienteIdStr = clienteContextService.getClienteId();
            if (clienteIdStr != null) {
                UUID clienteId = UUID.fromString(clienteIdStr);
                Cliente cliente = clienteRepository.findById(clienteId)
                        .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
                entidadeCliente.setCliente(cliente);
            }
        }

        return getService().salvar(entidade);
    }

    protected abstract DefaultService<E> getService();

}
