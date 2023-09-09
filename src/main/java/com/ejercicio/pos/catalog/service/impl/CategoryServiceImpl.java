package com.ejercicio.pos.catalog.service.impl;


import com.ejercicio.pos.catalog.dto.CategoryDTO;
import com.ejercicio.pos.catalog.exceptions.CatalogException;
import com.ejercicio.pos.catalog.model.entity.CategoryEntity;
import com.ejercicio.pos.catalog.model.mapper.CategoryMapper;
import com.ejercicio.pos.catalog.repository.CategoryRepository;
import com.ejercicio.pos.catalog.service.CategoryService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDTO save(CategoryDTO category) {
        CategoryEntity categoryEntity=mapper.toEntity(category);
        CategoryEntity resultCategoryEntity=categoryRepository.save(categoryEntity);
        return mapper.entityToDTO(resultCategoryEntity);
    }

    @Override
    public void delete(Long id) {
        CategoryEntity categoryToDelete=categoryRepository.findById(id)
                .orElseThrow(()->new CatalogException("Error obteniendo categoria a eliminar"));
        categoryRepository.delete(categoryToDelete);
    }

    @Override
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findByName(String name) {
        return categoryRepository.findByName(name)
                .map(mapper::entityToDTO)
                .orElseThrow(()->new CatalogException("No existe categoria"));
    }

    @Override
    public CategoryDTO findById(Long id) {
        return mapper.entityToDTO(categoryRepository.findById(id).get());
    }
}
