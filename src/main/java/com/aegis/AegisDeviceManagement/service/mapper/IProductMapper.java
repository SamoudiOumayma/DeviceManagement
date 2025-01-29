package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Product;
import com.aegis.AegisDeviceManagement.service.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IProductMapper {

ProductDTO toDTO(Product product);

Product toEntity(ProductDTO productDTO);

List<ProductDTO> toDTOList(List<Product> products);

List<Product> toEntityList(List<ProductDTO> productDTOs);
}
