package com.ejercicio.pos.catalog.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResponseListDTO {
    private List<ProductDTO> products;
    private int page;
    private int size;
    private int totalPages;
    private long totalElements;
}
