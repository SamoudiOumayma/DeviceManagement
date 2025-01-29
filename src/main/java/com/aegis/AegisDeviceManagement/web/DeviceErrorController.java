package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IDeviceErrorService;
import com.aegis.AegisDeviceManagement.service.dto.DeviceErrorDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class DeviceErrorController {

    private final IDeviceErrorService deviceErrorService;

    public DeviceErrorController(IDeviceErrorService deviceErrorService) {
        this.deviceErrorService = deviceErrorService;
    }

    @PostMapping("createDeviceError")
    public DeviceErrorDTO createDeviceError(@RequestBody DeviceErrorDTO deviceErrorDTO) {
        return deviceErrorService.createDeviceError(deviceErrorDTO);
    }

    @GetMapping("getDeviceError/{id}")
    public DeviceErrorDTO getDeviceErrorById(@PathVariable UUID id) {
        return deviceErrorService.getDeviceErrorById(id);
    }

    @GetMapping("getAllDeviceErrors")
    public List<DeviceErrorDTO> getAllDeviceErrors() {
        return deviceErrorService.getAllDeviceErrors();
    }

    @PutMapping("updateDeviceError/{id}")
    public DeviceErrorDTO updateDeviceError(@PathVariable UUID id, @RequestBody DeviceErrorDTO deviceErrorDTO){
        return deviceErrorService.updateDeviceError(id, deviceErrorDTO);
    }

    @DeleteMapping("deleteDeviceError/{id}")
    public void deleteDeviceError(@PathVariable UUID id) {
        deviceErrorService.deleteDeviceError(id);
    }
}
