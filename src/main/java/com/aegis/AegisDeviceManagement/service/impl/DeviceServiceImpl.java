package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.Device;
import com.aegis.AegisDeviceManagement.repository.IDeviceRepository;
import com.aegis.AegisDeviceManagement.service.IDeviceService;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import com.aegis.AegisDeviceManagement.service.mapper.IDeviceMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceServiceImpl implements IDeviceService {

    private final IDeviceRepository deviceRepository;
    private final IDeviceMapper deviceMapper;

    public DeviceServiceImpl(IDeviceRepository deviceRepository, IDeviceMapper deviceMapper) {
        this.deviceRepository = deviceRepository;
        this.deviceMapper = deviceMapper;
    }

    @Override
    public DeviceDTO createDevice(DeviceDTO deviceDTO) {
        return save(deviceMapper.toEntity(deviceDTO));
    }

    @Override
    public DeviceDTO updateDevice(UUID deviceId, DeviceDTO deviceDTO) {
        if(!deviceRepository.isDeleted ( deviceId )) {
            throw new RuntimeException ("device not found");
        }
        Device device = findDeviceById(deviceId);
        updateDeviceFields(device, deviceDTO);
        return save(device);
    }

    @Override
    public void deleteDevice(UUID deviceId) {
        if (!deviceRepository.existsById(deviceId)) {
            throw new RuntimeException("Device not found with ID: " + deviceId);
        }
        deviceRepository.softDelete(deviceId);
    }

    @Override
    public DeviceDTO getDeviceById(UUID deviceId) {
        if ( ! deviceRepository.isDeleted ( deviceId ) ) {
            throw new RuntimeException("Device not found with ID: " + deviceId);
        }
        return deviceMapper.toDTO ( findDeviceById ( deviceId ) );

    }

    @Override
    public List<DeviceDTO> getAllDevices() {
        return deviceRepository.findAllActive ()
                .stream()
                .map(deviceMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Device findDeviceById(UUID deviceId) {
        return deviceRepository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found with ID: " + deviceId));
    }

    private void updateDeviceFields(Device device, DeviceDTO deviceDTO) {
        device.setName(deviceDTO.getName());
        device.setTag(deviceDTO.getTag());
        device.setType(deviceDTO.getType());
        device.setStatus(deviceDTO.getStatus());
        device.setXCoordinate(deviceDTO.getXCoordinate());
        device.setYCoordinate(deviceDTO.getYCoordinate());
        device.setLastSeen(deviceDTO.getLastSeen());
        device.setUpdateFrequency(deviceDTO.getUpdateFrequency());
        device.setUpdatedAt ( LocalDateTime.from ( java.time.Instant.now () ) );
    }

    private DeviceDTO save(Device device) {
        return deviceMapper.toDTO(deviceRepository.save(device));
    }

}
