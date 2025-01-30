package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.ErrorDTO;

import java.util.List;
import java.util.UUID;

public interface IErrorService {

    ErrorDTO createDeviceError(ErrorDTO errorDTO);

    ErrorDTO updateDeviceError(UUID errorId, ErrorDTO errorDTO);

    void deleteDeviceError(UUID errorId);

    ErrorDTO getDeviceErrorById(UUID errorId);

    List<ErrorDTO> getAllDeviceErrors();

}
