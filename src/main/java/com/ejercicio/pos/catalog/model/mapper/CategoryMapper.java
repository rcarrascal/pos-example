package com.ejercicio.pos.catalog.model.mapper;


import com.ejercicio.pos.catalog.dto.CategoryDTO;
import com.ejercicio.pos.catalog.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CategoryMapper {

    CategoryEntity toEntity(CategoryDTO dto);

    CategoryDTO entityToDTO(CategoryEntity entity);
}
