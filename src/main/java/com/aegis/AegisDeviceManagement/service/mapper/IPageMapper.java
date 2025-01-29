package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Page;
import com.aegis.AegisDeviceManagement.service.dto.PageDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPageMapper {

    PageDTO toDTO(Page page);

    Page toEntity(PageDTO pageDTO);

    List<PageDTO> toDTOList(List<Page> pages);

    List<Page> toEntityList(List<PageDTO> pageDTOs);

}
