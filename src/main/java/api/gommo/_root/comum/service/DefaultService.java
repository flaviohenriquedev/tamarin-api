package api.gommo._root.comum.service;

import api.gommo._root.comum.dto.EntidadePadraoDTO;

import java.util.List;
import java.util.UUID;

public interface DefaultService<D extends EntidadePadraoDTO> {
    D buscarPorId(UUID id);
    List<D> listar();
    D salvar(D dto);
    D alterar(UUID id, D dto);
    void deletar(UUID id);
    List<D> salvarTodos(List<D> dtos);
}
