package api.tamarin._root.comum.service.impl;

import api.tamarin._root.comum.service.DefaultService;
import api.tamarin._root.comum.service.DtoMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.Field;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class DefaultServiceImpl<E, D> implements DefaultService<D> {

    protected abstract JpaRepository<E, UUID> getRepository();
    protected abstract DtoMapper<E, D> getMapper();

    public List<D> findAll() {
        return getRepository().findAll().stream()
                .map(getMapper()::toDto)
                .collect(Collectors.toList());
    }

    public D findById(UUID id) {
        return getRepository().findById(id)
                .map(getMapper()::toDto)
                .orElseThrow(() -> new EntityNotFoundException("ID " + id + " não encontrado"));
    }

    public D save(D dto) {
        E entity = getMapper().toEntity(dto);
        E saved = getRepository().save(entity);
        return getMapper().toDto(saved);
    }

    public D update(UUID id, D dto) {
        if (!getRepository().existsById(id)) {
            throw new EntityNotFoundException("ID " + id + " não encontrado");
        }

        E entity = getMapper().toEntity(dto);
        setId(entity, id); // define o ID da entidade
        E updated = getRepository().save(entity);
        return getMapper().toDto(updated);
    }

    public void delete(UUID id) {
        getRepository().deleteById(id);
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

