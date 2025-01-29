package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IPageService;
import com.aegis.AegisDeviceManagement.service.dto.PageDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class PageController {
    private final IPageService pageService;

    public PageController(IPageService pageService) {
        this.pageService = pageService;
    }

    @PostMapping("createPage")
    public PageDTO createPage(@RequestBody PageDTO pageDTO) {
        return pageService.createPage(pageDTO);
    }

    @GetMapping("getPage/{id}")
    public PageDTO getPageById(@PathVariable UUID id) {
        return pageService.getPageById(id);
    }

    @GetMapping("getAllPages")
    public List<PageDTO> getAllPages() {
        return pageService.getAllPages();
    }

    @PutMapping("updatePage/{id}")
    public PageDTO updatePage(@PathVariable UUID id, @RequestBody PageDTO pageDTO) {
        return pageService.updatePage(id, pageDTO);
    }

    @DeleteMapping("deletePage/{id}")
    public void deletePage(@PathVariable UUID id) {
        pageService.deletePage(id);
    }
}
