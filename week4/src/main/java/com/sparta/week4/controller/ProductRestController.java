package com.sparta.week4.controller;

import com.sparta.week4.models.Product;
import com.sparta.week4.models.ProductMypriceDto;
import com.sparta.week4.models.ProductRepository;
import com.sparta.week4.models.ProductRequestDto;
import com.sparta.week4.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;
    private final ProductService productService;

    @GetMapping("/api/products")
    public List<Product> readProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    // 설정 가격 변경
    @PutMapping("/api/products/{id}")
    public Long updateProduct(@PathVariable Long id, @RequestBody ProductMypriceDto requestDto) {
        return productService.update(id, requestDto);
    }
}
