package com.ejercicio.pos.catalog.model.mapper;


import com.ejercicio.pos.catalog.dto.ProductDTO;
import com.ejercicio.pos.catalog.model.entity.ProductEntity;
import org.mapstruct.Mapper;

@Mapper
public interface ProductMapper {

    ProductEntity toEntity(ProductDTO productDTO);

    ProductDTO entityToDTO(ProductEntity providerEntity);
}
