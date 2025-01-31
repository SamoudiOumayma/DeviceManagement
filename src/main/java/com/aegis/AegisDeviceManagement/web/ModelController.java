package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IModelService;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/device")
public class ModelController {
    private final IModelService modelService;

    public ModelController(IModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping
    public ModelDTO createModel(@RequestBody ModelDTO modelDTO) {
        return modelService.createModel(modelDTO);
    }

    @GetMapping("/{id}")
    public ModelDTO getModelById(@PathVariable UUID id) {
        return modelService.getModelById(id);
    }

    @GetMapping("/All")
    public List<ModelDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @PutMapping("/{id}")
    public ModelDTO updateModel(@PathVariable UUID id, @RequestBody ModelDTO modelDTO) {
        return modelService.updateModel(id, modelDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
    }
}
