package com.ejercicio.pos.catalog.service;


import com.ejercicio.pos.catalog.dto.ProductDTO;
import com.ejercicio.pos.catalog.dto.ResponseListDTO;

import java.util.List;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(Long id,ProductDTO productDTO);

    void delete(Long id);

    List<ProductDTO> findAll();

    ResponseListDTO findAllPageable(int page, int size);

    List<ProductDTO> findByName(String name);

    List<ProductDTO> findByBarCode(String barCode);

    ProductDTO findById(Long id) ;

}
