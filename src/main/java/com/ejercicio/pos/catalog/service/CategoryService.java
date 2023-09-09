package com.ejercicio.pos.catalog.service;


import com.ejercicio.pos.catalog.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO save(CategoryDTO category);

    void delete(Long id);

    List<CategoryDTO> findAll();

    CategoryDTO findByName(String name);

    CategoryDTO findById(Long id);
}
