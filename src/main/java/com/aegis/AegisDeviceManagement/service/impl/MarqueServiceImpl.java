package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.service.IMarqueService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import com.aegis.AegisDeviceManagement.repository.MarqueRepository;
import com.aegis.AegisDeviceManagement.service.mapper.IMarqueMapper;
import com.aegis.AegisDeviceManagement.domain.Marque;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarqueServiceImpl implements IMarqueService {

    private final MarqueRepository marqueRepository;
    private final IMarqueMapper marqueMapper;

    public MarqueServiceImpl(MarqueRepository marqueRepository, IMarqueMapper marqueMapper) {
        this.marqueRepository = marqueRepository;
        this.marqueMapper = marqueMapper;
    }

    @Override
    public MarqueDTO createMarque(MarqueDTO marqueDTO) {
        return save(marqueMapper.toEntity(marqueDTO));
    }

    @Override
    public MarqueDTO updateMarque(UUID marqueId, MarqueDTO marqueDTO) {
        Marque marque = findMarqueById(marqueId);
        updateMarqueFields(marque, marqueDTO);
        return save(marque);
    }

    @Override
    public void deleteMarque(UUID marqueId) {
        if (!marqueRepository.existsById(marqueId)) {
            throw new RuntimeException("Marque not found with ID: " + marqueId);
        }
        marqueRepository.deleteById(marqueId);
    }

    @Override
    public MarqueDTO getMarqueById(UUID marqueId) {
        return marqueMapper.toDTO(findMarqueById(marqueId));
    }

    @Override
    public List<MarqueDTO> getAllMarques() {
        return marqueRepository.findAll()
                .stream()
                .map(marqueMapper::toDTO)
                .collect(Collectors.toList());
    }


    private Marque findMarqueById(UUID marqueId) {
        return marqueRepository.findById(marqueId)
                .orElseThrow(() -> new RuntimeException("Marque not found with ID: " + marqueId));
    }

    private void updateMarqueFields(Marque marque, MarqueDTO marqueDTO) {
        marque.setMarqueName(marqueDTO.getMarqueName());
        marque.setDescription(marqueDTO.getDescription());
        marque.setLogo(marqueDTO.getLogo());
    }

    private MarqueDTO save(Marque marque) {
        return marqueMapper.toDTO(marqueRepository.save(marque));
    }

}
