package com.anup.productserviceitsevening.models;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class CategoryDeserializer extends JsonDeserializer<Category> {
    @Override
    public Category deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        Category category = new Category();
        category.setName(value); // Assuming the string value should be set as the category name
        return category;
    }
}