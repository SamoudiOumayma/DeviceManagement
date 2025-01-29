package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Marque;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarqueMapper {

<<<<<<< HEAD
    MarqueDTO toDTO(Marque marque);

    Marque toEntity(MarqueDTO marqueDTO);

    List<MarqueDTO> toDTOList(List<Marque> marques);

    List<Marque> toEntityList(List<MarqueDTO> marqueDTOs);
=======
MarqueDTO toDTO( Marque marque);

Marque toEntity(MarqueDTO marqueDTO);

List<MarqueDTO> toDTOList(List<Marque> marques);

List<Marque> toEntityList(List<MarqueDTO> marqueDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
