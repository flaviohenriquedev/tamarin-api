package api.tamarin._root.comum.service;

import api.tamarin._root.comum.dto.EntidadeDTO;

import java.util.List;
import java.util.UUID;

public interface DefaultService<D extends EntidadeDTO> {
    D buscarPorId(UUID id);
    List<D> listar();
    D salvar(D dto);
    D alterar(UUID id, D dto);
    void deletar(UUID id);
}
