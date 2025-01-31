package com.aegis.AegisDeviceManagement.service.mapper;

import java.util.List;

public interface IBaseMapper<E, D> {

	D toDTO(E entity);

	E toEntity(D dto);

	List<D> toDTOList(List<E> entities);

	List<E> toEntityList(List<D> dtos);
}
