package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Marque;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
@Mapper(componentModel = "spring")
public interface IMarqueMapper extends IBaseMapper<Marque, MarqueDTO> {

}
