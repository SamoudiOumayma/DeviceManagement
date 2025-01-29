package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.MT;
import com.aegis.AegisDeviceManagement.service.dto.MTDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMTMapper {

<<<<<<< HEAD
    MTDTO toDTO(MT mt);

    MT toEntity(MTDTO mtDTO);

    List<MTDTO> toDTOList(List<MT> mts);

    List<MT> toEntityList(List<MTDTO> mtDTOs);
=======
MTDTO toDTO( MT mt);

MT toEntity(MTDTO mtDTO);

List<MTDTO> toDTOList(List<MT> mts);

List<MT> toEntityList(List<MTDTO> mtDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
