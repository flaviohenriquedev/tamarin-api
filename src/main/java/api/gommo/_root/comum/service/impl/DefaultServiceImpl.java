package api.gommo._root.comum.service.impl;

import api.gommo._root.comum.dto.EntidadePadraoDTO;
import api.gommo._root.comum.repository.DefaultRepository;
import api.gommo._root.comum.service.DefaultService;
import api.gommo._root.comum.service.DtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public abstract class DefaultServiceImpl<E, D extends EntidadePadraoDTO> implements DefaultService<D> {

    protected abstract DefaultRepository<E, UUID> getRepository();

    protected abstract DtoMapper<E, D> getMapper();

    public List<D> listar() {
        return getRepository()
                .findAll()
                .stream()
                .map(e -> getMapper().toDto(e))
                .toList();
    }

    public D buscarPorId(UUID id) {
        return getRepository().findById(id)
                .map(getMapper()::toDto)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + " não encontrado"));
    }

    public D salvar(D dto) {
        E entity = getMapper().toEntity(dto);
        E saved = getRepository().save(entity);
        return getMapper().toDto(saved);
    }

    public D alterar(UUID id, D dto) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("ID " + id + " não encontrado");
        }

        E entity = getMapper().toEntity(dto);
        setId(entity, id); // define o ID da entidade
        E updated = getRepository().save(entity);
        return getMapper().toDto(updated);
    }

    public void deletar(UUID id) {
        getRepository().deleteById(id);
    }

    @Override
    public List<D> salvarTodos(List<D> dtos) {
        List<E> listaEntidade = getMapper().toEntityList(dtos);
        return getMapper().toDtoList(getRepository().saveAll(listaEntidade));
    }

    // Utilitário pra setar o ID via reflection (pra manter genérico)
    private void setId(E entity, UUID id) {
        try {
            Field field = entity.getClass().getDeclaredField("id");
            field.setAccessible(true);
            field.set(entity, id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao setar o ID na entidade", e);
        }
    }

}

