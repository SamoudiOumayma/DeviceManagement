package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Product;
import com.aegis.AegisDeviceManagement.service.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

<<<<<<< HEAD
    ProductDTO toDTO(Product product);

    Product toEntity(ProductDTO productDTO);

    List<ProductDTO> toDTOList(List<Product> products);

    List<Product> toEntityList(List<ProductDTO> productDTOs);
=======
ProductDTO toDTO(Product product);

Product toEntity(ProductDTO productDTO);

List<ProductDTO> toDTOList(List<Product> products);

List<Product> toEntityList(List<ProductDTO> productDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
