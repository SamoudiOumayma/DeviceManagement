package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IMarqueConfigService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/device")
public class MarqueConfigController {
    private final IMarqueConfigService marqueConfigService;

    public MarqueConfigController(IMarqueConfigService marqueConfigService) {
        this.marqueConfigService = marqueConfigService;
    }

    @PostMapping
    public MarqueConfigDTO createMarqueConfig(@RequestBody MarqueConfigDTO marqueConfigDTO) {
        return marqueConfigService.createMarqueConfig(marqueConfigDTO);
    }

    @GetMapping("/{id}")
    public MarqueConfigDTO getMarqueConfigById(@PathVariable UUID id) {
        return marqueConfigService.getMarqueConfigById(id);
    }

    @GetMapping("/All")
    public List<MarqueConfigDTO> getAllMarqueConfigs() {
        return marqueConfigService.getAllMarqueConfigs();
    }

    @PutMapping("/{id}")
    public MarqueConfigDTO updateMarqueConfig(@PathVariable UUID id, @RequestBody MarqueConfigDTO marqueConfigDTO) {
        return marqueConfigService.updateMarqueConfig(id, marqueConfigDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMarqueConfig(@PathVariable UUID id) {
        marqueConfigService.deleteMarqueConfig(id);
    }
}
