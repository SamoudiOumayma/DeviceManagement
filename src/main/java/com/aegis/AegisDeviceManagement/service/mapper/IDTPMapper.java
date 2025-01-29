package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.DTP;
import com.aegis.AegisDeviceManagement.service.dto.DTPDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDTPMapper {

<<<<<<< HEAD
    DTPDTO toDTO(DTP dtp);

    DTP toEntity(DTPDTO dtpDTO);

    List<DTPDTO> toDTOList(List<DTP> dtps);

    List<DTP> toEntityList(List<DTPDTO> dtpDTOs);
=======
DTPDTO toDTO( DTP dtp);

DTP toEntity(DTPDTO dtpDTO);

List<DTPDTO> toDTOList(List<DTP> dtps);

List<DTP> toEntityList(List<DTPDTO> dtpDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
