package com.anup.productserviceitsevening.services;

import org.springframework.web.bind.annotation.PathVariable;

public interface CategoryService {
    String getAllCategories();

    String getProductinCategory( Long categoryId);
}
