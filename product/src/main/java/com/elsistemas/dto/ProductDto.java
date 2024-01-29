package com.elsistemas.dto;

import com.elsistemas.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Long id;

    private String name;
    private String description;
    private String category;
    private String model;
    private BigDecimal price;

    public static ProductDto to(Product p) {
        return ProductDto.builder()
                .id(p.getId())
                .name(p.getName())
                .description(p.getDescription())
                .category(p.getCategory())
                .model(p.getModel())
                .price(p.getPrice())
                .build();
    }

    public static Product to(ProductDto p, Long id) {
        return Product.builder()
                .id(id)
                .name(p.getName())
                .description(p.getDescription())
                .category(p.getCategory())
                .model(p.getModel())
                .price(p.getPrice())
                .build();
    }


}
