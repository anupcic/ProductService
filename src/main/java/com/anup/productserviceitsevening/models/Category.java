package com.anup.productserviceitsevening.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class Category{
    private long id;
    private String name;
    private String description;
    private List<Product> products;
}
