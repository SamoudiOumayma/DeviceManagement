package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.DTP;
import com.aegis.AegisDeviceManagement.service.dto.DTPDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDTPMapper {

DTPDTO toDTO( DTP dtp);

DTP toEntity(DTPDTO dtpDTO);

List<DTPDTO> toDTOList(List<DTP> dtps);

List<DTP> toEntityList(List<DTPDTO> dtpDTOs);
}
