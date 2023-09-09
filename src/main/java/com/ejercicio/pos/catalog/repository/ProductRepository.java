package com.ejercicio.pos.catalog.repository;


import com.ejercicio.pos.catalog.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findTop10ByNameContainsOrderByNameAsc(String name);

    List<ProductEntity> findTop10ByBarCodeContainsOrderByNameAsc(String barCode);

}
