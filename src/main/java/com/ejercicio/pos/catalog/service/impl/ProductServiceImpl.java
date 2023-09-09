package com.ejercicio.pos.catalog.service.impl;


import com.ejercicio.pos.catalog.dto.ProductDTO;
import com.ejercicio.pos.catalog.dto.ResponseListDTO;
import com.ejercicio.pos.catalog.exceptions.CatalogException;
import com.ejercicio.pos.catalog.model.entity.ProductEntity;
import com.ejercicio.pos.catalog.model.mapper.ProductMapper;
import com.ejercicio.pos.catalog.repository.ProductRepository;
import com.ejercicio.pos.catalog.service.ProductService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private ProductMapper mapper = Mappers.getMapper(ProductMapper.class);

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(ProductDTO product) {
        ProductEntity productEntity=mapper.toEntity(product);
        return mapper.entityToDTO(productRepository.save(productEntity));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        ProductEntity productEntity=productRepository.getReferenceById(id);
        productEntity.setBarCode(productDTO.getBarCode());
        productEntity.setName(productDTO.getName());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setCost(productDTO.getCost());
        productEntity.setQuantity(productDTO.getQuantity());
        return mapper.entityToDTO(productRepository.save(productEntity));
    }

    @Override
    public void delete(Long id) {
        ProductEntity productToDelete=productRepository.findById(id)
                .orElseThrow(()->new CatalogException("Error obteniendo producto a eliminar"));
        productRepository.delete(productToDelete);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(data->mapper.entityToDTO(data))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseListDTO findAllPageable(int page, int size) {
        Pageable pagination = PageRequest.of(page, size, Sort.by("name").ascending());
        Page<ProductEntity> allProducts = productRepository.findAll(pagination);

        List<ProductDTO> products=allProducts.getContent()
                .stream()
                .map(data->mapper.entityToDTO(data))
                .collect(Collectors.toList());

        return ResponseListDTO.builder()
                .products(products)
                .totalPages(allProducts.getTotalPages())
                .size(allProducts.getSize())
                .totalElements(allProducts.getTotalElements())
                .build();
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        return productRepository.findTop10ByNameContainsOrderByNameAsc(name)
                .stream()
                .map(data->mapper.entityToDTO(data))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByBarCode(String barCode) {
        return productRepository.findTop10ByBarCodeContainsOrderByNameAsc(barCode)
                .stream()
                .map(data->mapper.entityToDTO(data))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        return mapper.entityToDTO(productRepository.findById(id).get());
    }
}
