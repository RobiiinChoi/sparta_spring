package com.sparta.week4.controller;

import com.sparta.week4.models.Product;
import com.sparta.week4.models.ProductMypriceDto;
import com.sparta.week4.models.ProductRepository;
import com.sparta.week4.models.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class ProductRestController {

    private final ProductRepository productRepository;

    @GetMapping("/api/products")
    public List<Product> readProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/api/products")
    public Product createProduct(@RequestBody ProductRequestDto requestDto){
        Product product = new Product(requestDto);
        return productRepository.save(product);
    }

    @PutMapping("/api/products/${targetId}")
    public Product setMyPrice(@RequestBody ProductMypriceDto requestDto){
        Product product = new product(requestDto);

    }
}
