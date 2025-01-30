package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.Error;
import com.aegis.AegisDeviceManagement.repository.ErrorRepository;
import com.aegis.AegisDeviceManagement.service.IErrorService;
import com.aegis.AegisDeviceManagement.service.dto.ErrorDTO;

import com.aegis.AegisDeviceManagement.service.mapper.IErrorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ErrorServiceImpl implements IErrorService {

    private final ErrorRepository errorRepository;
    private final IErrorMapper deviceErrorMapper;

    public ErrorServiceImpl(ErrorRepository errorRepository, IErrorMapper deviceErrorMapper) {
        this.errorRepository = errorRepository;
        this.deviceErrorMapper = deviceErrorMapper;
    }

    @Override
    public ErrorDTO createDeviceError(ErrorDTO errorDTO) {
        return save(deviceErrorMapper.toEntity(errorDTO));
    }

    @Override
    public ErrorDTO updateDeviceError(UUID errorId, ErrorDTO errorDTO) {
        Error deviceError = findDeviceErrorById(errorId);
        updateDeviceErrorFields(deviceError, errorDTO);
        return save(deviceError);
    }

    @Override
    public void deleteDeviceError(UUID errorId) {
        if (!errorRepository.existsById(errorId)) {
            throw new RuntimeException("DeviceError not found with ID: " + errorId);
        }
        errorRepository.deleteById(errorId);
    }

    @Override
    public ErrorDTO getDeviceErrorById(UUID errorId) {
        return deviceErrorMapper.toDTO(findDeviceErrorById(errorId));
    }

    @Override
    public List<ErrorDTO> getAllDeviceErrors() {
        return errorRepository.findAll()
                .stream()
                .map(deviceErrorMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Error findDeviceErrorById(UUID errorId) {
        return errorRepository.findById(errorId)
                .orElseThrow(() -> new RuntimeException("DeviceError not found with ID: " + errorId));
    }

    private void updateDeviceErrorFields(Error deviceError, ErrorDTO errorDTO) {
        deviceError.setReferenced(errorDTO.getReferenced());
        deviceError.setType(errorDTO.getType());
        deviceError.setMessage(errorDTO.getMessage());
        deviceError.setRetryCount(errorDTO.getRetryCount());
        deviceError.setReferenceType(errorDTO.getReferenceType());
        deviceError.setErrorCode(errorDTO.getErrorCode());
        deviceError.setSupplierStatus(errorDTO.getSupplierStatus());
        deviceError.setAttemptAt(errorDTO.getAttemptAt());
    }

    private ErrorDTO save(Error deviceError) {
        return deviceErrorMapper.toDTO(errorRepository.save(deviceError));
    }

}
