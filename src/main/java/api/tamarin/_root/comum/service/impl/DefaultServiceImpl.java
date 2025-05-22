package api.tamarin._root.comum.service.impl;

import api.tamarin._root.comum.dto.EntidadeDTO;
import api.tamarin._root.comum.service.DefaultService;
import api.tamarin._root.comum.service.DtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;

public abstract class DefaultServiceImpl<E, D extends EntidadeDTO> implements DefaultService<D> {

    protected abstract JpaRepository<E, UUID> getPerfilRepository();
    protected abstract DtoMapper<E, D> getMapper();

    public List<D> listar() {
        return getPerfilRepository()
                .findAll()
                .stream()
                .map(e -> getMapper().toDto(e))
                .toList();
    }

    public D buscarPorId(UUID id) {
        return getPerfilRepository().findById(id)
                .map(getMapper()::toDto)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + " não encontrado"));
    }

    public D salvar(D dto) {
        E entity = getMapper().toEntity(dto);
        E saved = getPerfilRepository().save(entity);
        return getMapper().toDto(saved);
    }

    public D alterar(UUID id, D dto) {
        if (!getPerfilRepository().existsById(id)) {
            throw new EntityNotFoundException("ID " + id + " não encontrado");
        }

        E entity = getMapper().toEntity(dto);
        setId(entity, id); // define o ID da entidade
        E updated = getPerfilRepository().save(entity);
        return getMapper().toDto(updated);
    }

    public void deletar(UUID id) {
        getPerfilRepository().deleteById(id);
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

