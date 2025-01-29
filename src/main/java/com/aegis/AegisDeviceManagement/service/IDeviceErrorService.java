package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.DeviceErrorDTO;

import java.util.List;
import java.util.UUID;

public interface IDeviceErrorService {

DeviceErrorDTO createDeviceError( DeviceErrorDTO deviceErrorDTO);

DeviceErrorDTO updateDeviceError( UUID errorId, DeviceErrorDTO deviceErrorDTO);

void deleteDeviceError(UUID errorId);

DeviceErrorDTO getDeviceErrorById(UUID errorId);

List <DeviceErrorDTO> getAllDeviceErrors();
}
