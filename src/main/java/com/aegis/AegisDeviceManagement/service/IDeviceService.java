package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;

import java.util.List;
import java.util.UUID;

public interface IDeviceService {

 DeviceDTO createDevice( DeviceDTO deviceDTO);

 DeviceDTO updateDevice( UUID deviceId, DeviceDTO deviceDTO);

void deleteDevice(UUID deviceId);

DeviceDTO getDeviceById(UUID deviceId);

List <DeviceDTO> getAllDevices();
}
