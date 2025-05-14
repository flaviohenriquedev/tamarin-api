package api.tamarin._root.comum.service;

public interface DtoConverter<E, D> {
    D toDto(E entity);

    E toEntity(D dto);
}