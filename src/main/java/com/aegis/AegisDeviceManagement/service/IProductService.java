package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.ProductDTO;
import java.util.List;
import java.util.UUID;

public interface IProductService {

    ProductDTO createProduct(ProductDTO productDTO);

    ProductDTO updateProduct(UUID productId, ProductDTO productDTO);

    void deleteProduct(UUID productId);

    ProductDTO getProductById(UUID productId);

    List<ProductDTO> getAllProducts();
}
