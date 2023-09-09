package com.ejercicio.pos.catalog.controllers;



import com.ejercicio.pos.catalog.dto.CategoryDTO;
import com.ejercicio.pos.catalog.model.entity.CategoryEntity;
import com.ejercicio.pos.catalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public CategoryDTO save(@RequestBody CategoryDTO category) throws Exception {
        return categoryService.save(category);
    }

    @GetMapping
    public List<CategoryDTO> findAll() throws Exception {
        return categoryService.findAll();
    }

    @GetMapping("{id}")
    public CategoryDTO findById(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }
}
