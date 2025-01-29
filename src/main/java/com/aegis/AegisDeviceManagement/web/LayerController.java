package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.ILayerService;
import com.aegis.AegisDeviceManagement.service.dto.LayerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class LayerController {
    private final ILayerService layerService;

    public LayerController(ILayerService layerService) {
        this.layerService = layerService;
    }

    @PostMapping("createLayer")
    public LayerDTO createLayer(@RequestBody LayerDTO layerDTO) {
        return layerService.createLayer(layerDTO);
    }

    @GetMapping("getLayer/{id}")
    public LayerDTO getLayerById(@PathVariable UUID id) {
        return layerService.getLayerById(id);
    }

    @GetMapping("getAllLayers")
    public List<LayerDTO> getAllLayers() {
        return layerService.getAllLayers();
    }

    @PutMapping("updateLayer/{id}")
    public LayerDTO updateLayer(@PathVariable UUID id, @RequestBody LayerDTO layerDTO) {
        return layerService.updateLayer(id, layerDTO);
    }

    @DeleteMapping("deleteLayer/{id}")
    public void deleteLayer(@PathVariable UUID id) {
        layerService.deleteLayer(id);
    }
}
