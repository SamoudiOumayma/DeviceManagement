package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IErrorService;
import com.aegis.AegisDeviceManagement.service.dto.ErrorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class DeviceErrorController {

    private final IErrorService deviceErrorService;

    public DeviceErrorController(IErrorService deviceErrorService) {
        this.deviceErrorService = deviceErrorService;
    }

    @PostMapping("createDeviceError")
    public ErrorDTO createDeviceError(@RequestBody ErrorDTO errorDTO) {
        return deviceErrorService.createDeviceError(errorDTO);
    }

    @GetMapping("getDeviceError/{id}")
    public ErrorDTO getDeviceErrorById(@PathVariable UUID id) {
        return deviceErrorService.getDeviceErrorById(id);
    }

    @GetMapping("getAllDeviceErrors")
    public List<ErrorDTO> getAllDeviceErrors() {
        return deviceErrorService.getAllDeviceErrors();
    }

    @PutMapping("updateDeviceError/{id}")
    public ErrorDTO updateDeviceError(@PathVariable UUID id, @RequestBody ErrorDTO errorDTO){
        return deviceErrorService.updateDeviceError(id, errorDTO);
    }

    @DeleteMapping("deleteDeviceError/{id}")
    public void deleteDeviceError(@PathVariable UUID id) {
        deviceErrorService.deleteDeviceError(id);
    }
}
