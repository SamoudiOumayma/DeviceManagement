package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import java.util.List;
import java.util.UUID;

public interface IMarqueService {
MarqueDTO createMarque(MarqueDTO marqueDTO);
MarqueDTO updateMarque(UUID marqueId, MarqueDTO marqueDTO);
void deleteMarque(UUID marqueId);
MarqueDTO getMarqueById(UUID marqueId);
List<MarqueDTO> getAllMarques();
}
