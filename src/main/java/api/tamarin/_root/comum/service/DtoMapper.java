package api.tamarin._root.comum.service;

import java.util.List;

public interface DtoMapper<E, D> {
    D toDto(E entity);
    E toEntity(D dto);
    List<D> toDtoList(List<E> entities);
    List<E> toEntityList(List<D> dtoList);
}
