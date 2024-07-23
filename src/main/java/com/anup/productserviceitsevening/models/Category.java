package com.anup.productserviceitsevening.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@JsonDeserialize(using = CategoryDeserializer.class)

public class Category{
    private long id;
    private String name;
    private String description;
    private List<Product> products;
}
