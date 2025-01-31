package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.repository.IProductRepository;
import com.aegis.AegisDeviceManagement.service.IProductService;
import com.aegis.AegisDeviceManagement.service.dto.ProductDTO;
import com.aegis.AegisDeviceManagement.service.mapper.IProductMapper;
import com.aegis.AegisDeviceManagement.domain.Product;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository productRepository;
    private final IProductMapper productMapper;

    public ProductServiceImpl(IProductRepository productRepository, IProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {

        return save(productMapper.toEntity(productDTO));
    }

    @Override
    public ProductDTO updateProduct(UUID productId, ProductDTO productDTO) {
        if(!productRepository.isDeleted ( productId )) {
            throw new RuntimeException ("product not found");
        }
        Product product = findProductById(productId);
        updateProductFields(product, productDTO);
        return save(product);
    }

    @Override
    public void deleteProduct(UUID productId) {
        if ( !productRepository.existsById(productId)) {
        throw new RuntimeException("prouct not found with ID: " + productId);
    }
        productRepository.softDelete (productId);
    }

    @Override
    public ProductDTO getProductById(UUID productId) {

        if(!productRepository.isDeleted ( productId )) {
            throw new RuntimeException ("product not found");
        }
        return productMapper.toDTO(findProductById(productId));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAllActive ()
                .stream()
                .map(productMapper::toDTO)
                .collect(Collectors.toList());
    }


    private Product findProductById(UUID productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + productId));
    }

    private void updateProductFields(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setOriginalId(productDTO.getOriginalId());
        product.setData(productDTO.getData());
        product.setUpdatedAt ( LocalDateTime.from ( java.time.Instant.now () ) );
    }

    private ProductDTO save(Product product) {
        return productMapper.toDTO(productRepository.save(product));
    }

}
