package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.PageDTO;

import java.util.List;
import java.util.UUID;

public interface IPageService {
    PageDTO createPage(PageDTO pageDTO);

    PageDTO updatePage(UUID pageId, PageDTO pageDTO);

    void deletePage(UUID pageId);

    PageDTO getPageById(UUID pageId);

    List<PageDTO> getAllPages();
}
