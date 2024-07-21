package com.anup.productserviceitsevening.models;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class Product{
    private Long id;
    private String title;
    private String description;
    private double price;
    private Category category;
    private String imageUrl;
}
