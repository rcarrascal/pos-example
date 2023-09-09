package com.ejercicio.pos.catalog.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Long id;

    private String name;

    private List<CategoryDTO> categories;

    private String barCode;

    private String description;

    private Double price;

    private Double specialPrice;

    private Double cost;

    private Integer quantity;
}
