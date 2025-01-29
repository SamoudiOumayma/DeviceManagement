package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.IProductService;
import com.aegis.AegisDeviceManagement.service.dto.ProductDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping("createProduct")
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @GetMapping("getProduct/{id}")
    public ProductDTO getProductById(@PathVariable UUID id) {
        return productService.getProductById(id);
    }

    @GetMapping("getAllProducts")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PutMapping("updateProduct/{id}")
    public ProductDTO updateProduct(@PathVariable UUID id, @RequestBody ProductDTO productDTO) {
        return productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProduct(@PathVariable UUID id) {
        productService.deleteProduct(id);
    }
}
