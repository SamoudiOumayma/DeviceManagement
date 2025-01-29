package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Page;
import com.aegis.AegisDeviceManagement.service.dto.PageDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IPageMapper {

<<<<<<< HEAD
    PageDTO toDTO(Page page);

    Page toEntity(PageDTO pageDTO);

    List<PageDTO> toDTOList(List<Page> pages);

    List<Page> toEntityList(List<PageDTO> pageDTOs);
=======
PageDTO toDTO( Page page);

Page toEntity(PageDTO pageDTO);

List<PageDTO> toDTOList(List<Page> pages);

List<Page> toEntityList(List<PageDTO> pageDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
