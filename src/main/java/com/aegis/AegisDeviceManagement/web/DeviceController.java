package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IDeviceService;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class DeviceController {

    private final IDeviceService deviceService;

    public DeviceController(IDeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @PostMapping("createDevice")
    DeviceDTO createDevice(@RequestBody DeviceDTO deviceDTO) {
        return deviceService.createDevice(deviceDTO);
    }

    @GetMapping("getDevice/{id}")
    public DeviceDTO getDeviceById(@PathVariable UUID id) {
        return deviceService.getDeviceById(id);
    }

    @GetMapping("getAllDevices")
    List<DeviceDTO> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @PutMapping("updateDevice/{id}")
    public DeviceDTO updateDevice(@PathVariable UUID id, @RequestBody DeviceDTO deviceDTO) {
        return deviceService.updateDevice(id, deviceDTO);
    }

    @DeleteMapping("deleteDevice/{id}")
    public void deleteDevice(@PathVariable UUID id) {
        deviceService.deleteDevice(id);
    }

}
