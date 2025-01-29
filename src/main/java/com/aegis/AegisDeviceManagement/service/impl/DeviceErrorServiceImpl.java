package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.DeviceError;
import com.aegis.AegisDeviceManagement.repository.DeviceErrorRepository;
import com.aegis.AegisDeviceManagement.service.IDeviceErrorService;
import com.aegis.AegisDeviceManagement.service.dto.DeviceErrorDTO;

import com.aegis.AegisDeviceManagement.service.mapper.IDeviceErrorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DeviceErrorServiceImpl implements IDeviceErrorService {

    private final DeviceErrorRepository deviceErrorRepository;
    private final IDeviceErrorMapper deviceErrorMapper;

    public DeviceErrorServiceImpl(DeviceErrorRepository deviceErrorRepository, IDeviceErrorMapper deviceErrorMapper) {
        this.deviceErrorRepository = deviceErrorRepository;
        this.deviceErrorMapper = deviceErrorMapper;
    }

    @Override
    public DeviceErrorDTO createDeviceError(DeviceErrorDTO deviceErrorDTO) {
        return save(deviceErrorMapper.toEntity(deviceErrorDTO));
    }

    @Override
    public DeviceErrorDTO updateDeviceError(UUID errorId, DeviceErrorDTO deviceErrorDTO) {
        DeviceError deviceError = findDeviceErrorById(errorId);
        updateDeviceErrorFields(deviceError, deviceErrorDTO);
        return save(deviceError);
    }

    @Override
    public void deleteDeviceError(UUID errorId) {
        if (!deviceErrorRepository.existsById(errorId)) {
            throw new RuntimeException("DeviceError not found with ID: " + errorId);
        }
        deviceErrorRepository.deleteById(errorId);
    }

    @Override
    public DeviceErrorDTO getDeviceErrorById(UUID errorId) {
        return deviceErrorMapper.toDTO(findDeviceErrorById(errorId));
    }

    @Override
    public List<DeviceErrorDTO> getAllDeviceErrors() {
        return deviceErrorRepository.findAll()
                .stream()
                .map(deviceErrorMapper::toDTO)
                .collect(Collectors.toList());
    }

    private DeviceError findDeviceErrorById(UUID errorId) {
        return deviceErrorRepository.findById(errorId)
                .orElseThrow(() -> new RuntimeException("DeviceError not found with ID: " + errorId));
    }

    private void updateDeviceErrorFields(DeviceError deviceError, DeviceErrorDTO deviceErrorDTO) {
        deviceError.setReferenced(deviceErrorDTO.getReferenced());
        deviceError.setErrorType(deviceErrorDTO.getErrorType());
        deviceError.setErrorMessage(deviceErrorDTO.getErrorMessage());
        deviceError.setRetryCount(deviceErrorDTO.getRetryCount());
        deviceError.setReferenceType(deviceErrorDTO.getReferenceType());
        deviceError.setErrorCode(deviceErrorDTO.getErrorCode());
        deviceError.setSupplierStatus(deviceErrorDTO.getSupplierStatus());
        deviceError.setAttemptAt(deviceErrorDTO.getAttemptAt());
    }

    private DeviceErrorDTO save(DeviceError deviceError) {
        return deviceErrorMapper.toDTO(deviceErrorRepository.save(deviceError));
    }
}
