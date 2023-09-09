package com.ejercicio.pos.catalog.controllers;



import com.ejercicio.pos.catalog.dto.ProductDTO;
import com.ejercicio.pos.catalog.dto.ResponseListDTO;
import com.ejercicio.pos.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catalog/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ProductDTO save(@RequestBody ProductDTO product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public ProductDTO update(@PathVariable("id")Long id,@RequestBody ProductDTO product) {
        return productService.update(id,product);
    }

    @GetMapping("/{name}")
    public List<ProductDTO> findByName(@PathVariable("name") String name) throws Exception {
        return productService.findByName(name);
    }

    @GetMapping("barCode/{barCode}")
    public List<ProductDTO> findByBarCode(@PathVariable("barCode") String barCode) throws Exception {
        return productService.findByBarCode(barCode);
    }

    @GetMapping("/getById/{id}")
    public ProductDTO getById(@PathVariable("id") Long id) throws Exception {
        return productService.findById(id);
    }
    @GetMapping("/page/{page}/size/{size}")
    public ResponseListDTO findAllPageable(@PathVariable("page") int page, @PathVariable("size") int size) throws Exception {
        return productService.findAllPageable(page,size);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id")Long id) throws Exception {
        productService.delete(id);
    }
}
