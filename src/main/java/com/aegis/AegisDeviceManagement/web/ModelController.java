package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IModelService;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class ModelController {
    private final IModelService modelService;

    public ModelController(IModelService modelService) {
        this.modelService = modelService;
    }

    @PostMapping("createModel")
    public ModelDTO createModel(@RequestBody ModelDTO modelDTO) {
        return modelService.createModel(modelDTO);
    }

    @GetMapping("getModel/{id}")
    public ModelDTO getModelById(@PathVariable UUID id) {
        return modelService.getModelById(id);
    }

    @GetMapping
    public List<ModelDTO> getAllModels() {
        return modelService.getAllModels();
    }

    @PutMapping("updateModel/{id}")
    public ModelDTO updateModel(@PathVariable UUID id, @RequestBody ModelDTO modelDTO) {
        return modelService.updateModel(id, modelDTO);
    }

    @DeleteMapping("deleteModel/{id}")
    public void deleteModel(@PathVariable UUID id) {
        modelService.deleteModel(id);
    }
}
