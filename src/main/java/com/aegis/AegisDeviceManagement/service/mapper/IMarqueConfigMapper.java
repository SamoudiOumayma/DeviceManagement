package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarqueConfigMapper {

<<<<<<< HEAD
    MarqueConfigDTO toDTO(MarqueConfig marqueConfig);

    MarqueConfig toEntity(MarqueConfigDTO marqueConfigDTO);

    List<MarqueConfigDTO> toDTOList(List<MarqueConfig> marqueConfigs);

    List<MarqueConfig> toEntityList(List<MarqueConfigDTO> marqueConfigDTOs);
=======
MarqueConfigDTO toDTO( MarqueConfig marqueConfig);

MarqueConfig toEntity(MarqueConfigDTO marqueConfigDTO);

List<MarqueConfigDTO> toDTOList(List<MarqueConfig> marqueConfigs);

List<MarqueConfig> toEntityList(List<MarqueConfigDTO> marqueConfigDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
