package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IMarqueService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/device")
public class MarqueController {
    private final IMarqueService marqueService;

    public MarqueController(IMarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @PostMapping
    public MarqueDTO createMarque(@RequestBody MarqueDTO marqueDTO) {
        return marqueService.createMarque(marqueDTO);
    }

    @GetMapping("/{id}")
    public MarqueDTO getMarqueById(@PathVariable UUID id) {
        return marqueService.getMarqueById(id);
    }

    @GetMapping("/All")
    public List<MarqueDTO> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @PutMapping("/{id}")
    public MarqueDTO updateMarque(@PathVariable UUID id, @RequestBody MarqueDTO marqueDTO) {
        return marqueService.updateMarque(id, marqueDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMarque(@PathVariable UUID id) {
        marqueService.deleteMarque(id);
    }
}
