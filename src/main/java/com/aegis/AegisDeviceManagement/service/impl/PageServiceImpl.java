package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.service.IPageService;
import com.aegis.AegisDeviceManagement.service.dto.PageDTO;
import com.aegis.AegisDeviceManagement.repository.PageRepository;
import com.aegis.AegisDeviceManagement.service.mapper.IPageMapper;
import com.aegis.AegisDeviceManagement.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PageServiceImpl implements IPageService {

    private final PageRepository pageRepository;
    private final IPageMapper pageMapper;

    public PageServiceImpl(PageRepository pageRepository, IPageMapper pageMapper) {
        this.pageRepository = pageRepository;
        this.pageMapper = pageMapper;
    }

    @Override
    public PageDTO createPage(PageDTO pageDTO) {
        return save(pageMapper.toEntity(pageDTO));
    }

    @Override
    public PageDTO updatePage(UUID pageId, PageDTO pageDTO) {
        Page page = findPageById(pageId);
        updatePageFields(page, pageDTO);
        return save(page);
    }

    @Override
    public void deletePage(UUID pageId) {
        if (!pageRepository.existsById(pageId)) {
            throw new RuntimeException("Page not found with ID: " + pageId);
        }
        pageRepository.deleteById(pageId);
    }

    @Override
    public PageDTO getPageById(UUID pageId) {
        return pageMapper.toDTO(findPageById(pageId));
    }

    @Override
    public List<PageDTO> getAllPages() {
        return pageRepository.findAll()
                .stream()
                .map(pageMapper::toDTO)
                .collect(Collectors.toList());
    }


    private Page findPageById(UUID pageId) {
        return pageRepository.findById(pageId)
                .orElseThrow(() -> new RuntimeException("Page not found with ID: " + pageId));
    }

    private void updatePageFields(Page page, PageDTO pageDTO) {
        page.setName(pageDTO.getName());
        page.setCondition(pageDTO.getCondition());
        page.setCanvas(pageDTO.getCanvas());
    }

    private PageDTO save(Page page) {
        return pageMapper.toDTO(pageRepository.save(page));
    }

}
