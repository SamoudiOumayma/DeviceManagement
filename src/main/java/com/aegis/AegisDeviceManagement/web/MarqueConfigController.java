package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IMarqueConfigService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class MarqueConfigController {
    private final IMarqueConfigService marqueConfigService;

    public MarqueConfigController(IMarqueConfigService marqueConfigService) {
        this.marqueConfigService = marqueConfigService;
    }

    @PostMapping("createMarqueConfig")
    public MarqueConfigDTO createMarqueConfig(@RequestBody MarqueConfigDTO marqueConfigDTO) {
        return marqueConfigService.createMarqueConfig(marqueConfigDTO);
    }

    @GetMapping("getMarqueConfig/{id}")
    public MarqueConfigDTO getMarqueConfigById(@PathVariable UUID id) {
        return marqueConfigService.getMarqueConfigById(id);
    }

    @GetMapping("getAllMarqueConfigs")
    public List<MarqueConfigDTO> getAllMarqueConfigs() {
        return marqueConfigService.getAllMarqueConfigs();
    }

    @PutMapping("updateMarqueConfig/{id}")
    public MarqueConfigDTO updateMarqueConfig(@PathVariable UUID id, @RequestBody MarqueConfigDTO marqueConfigDTO) {
        return marqueConfigService.updateMarqueConfig(id, marqueConfigDTO);
    }

    @DeleteMapping("deleteMarqueConfig/{id}")
    public void deleteMarqueConfig(@PathVariable UUID id) {
        marqueConfigService.deleteMarqueConfig(id);
    }
}
