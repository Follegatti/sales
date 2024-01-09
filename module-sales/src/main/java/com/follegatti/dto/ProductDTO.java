package com.follegatti.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDTO {
    private Integer idProduct;
    private Integer idCategory;
    private String nameProduct;
    private String descriptionProduct;
    private double priceProduct;
    private boolean enabledProduct;
}
