package api.tamarin._root.comum.service.impl;

import api.tamarin._root.comum.service.DtoMapper;
import org.modelmapper.ModelMapper;

public class DtoMapperImpl<E, D> implements DtoMapper<E, D> {

    private final Class<E> entityClass;
    private final Class<D> dtoClass;
    private final ModelMapper mapper;

    public DtoMapperImpl(ModelMapper mapper, Class<E> entityClass, Class<D> dtoClass) {
        this.mapper = mapper;
        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
    }

    @Override
    public D toDto(E entity) {
        return mapper.map(entity, dtoClass);
    }

    @Override
    public E toEntity(D dto) {
        return mapper.map(dto, entityClass);
    }
}
