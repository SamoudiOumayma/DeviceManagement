package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IDeviceService;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/device")
public class DeviceController {

    private final IDeviceService deviceService;

    public DeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping
    DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return deviceService.createDevice(deviceDTO);
    }

    @GetMapping("/{id}")
    public DeviceDTO getDeviceById(@PathVariable UUID id) {
        return deviceService.getDeviceById(id);
    }

    @GetMapping("/All")
    List<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("/{id}")
    public DeviceDTO updateDevice(@PathVariable UUID id, @RequestBody DeviceDTO deviceDTO) {
        return deviceService.updateDevice(id, deviceDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteDevice(@PathVariable UUID id) {
        deviceService.deleteDevice(id);
    }

}
