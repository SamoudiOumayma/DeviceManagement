package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IMarqueService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class MarqueController {
    private final IMarqueService marqueService;

    public MarqueController(IMarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @PostMapping("createMarque")
    public MarqueDTO createMarque(@RequestBody MarqueDTO marqueDTO) {
        return marqueService.createMarque(marqueDTO);
    }

    @GetMapping("getMarque/{id}")
    public MarqueDTO getMarqueById(@PathVariable UUID id) {
        return marqueService.getMarqueById(id);
    }

    @GetMapping("getAllMarques")
    public List<MarqueDTO> getAllMarques() {
        return marqueService.getAllMarques();
    }

    @PutMapping("updateMarque/{id}")
    public MarqueDTO updateMarque(@PathVariable UUID id, @RequestBody MarqueDTO marqueDTO) {
        return marqueService.updateMarque(id, marqueDTO);
    }

    @DeleteMapping("deleteMarque/{id}")
    public void deleteMarque(@PathVariable UUID id) {
        marqueService.deleteMarque(id);
    }
}
