package com.elsistemas.dto;

import lombok.*;

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

}
