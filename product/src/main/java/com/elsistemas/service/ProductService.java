package com.elsistemas.service;

import com.elsistemas.dto.ProductDto;
import com.elsistemas.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@ApplicationScoped
public class ProductService {

    private final ProductRepository productRepository;

    public List<ProductDto> getAllProduct() {
        List<ProductDto> products = new ArrayList<>();
        products = productRepository.findAll().stream().map(ProductDto::to).collect(Collectors.toList());
        return  products;
    }

    public void createNewProduct(ProductDto dto) {
        productRepository.persist(ProductDto.to(dto, null));
    }

    public void changeProduct(Long id, ProductDto dto) {
        var product = productRepository.findById(id);
        product.setName(dto.getName());
        product.setDescription(dto.getDescription());
        product.setCategory(dto.getCategory());
        product.setModel(dto.getModel());
        product.setPrice(dto.getPrice());
        productRepository.persist(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto findById(Long id) {
        return ProductDto.to(productRepository.findById(id));
    }
}
