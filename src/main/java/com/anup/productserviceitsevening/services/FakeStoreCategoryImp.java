package com.anup.productserviceitsevening.services;

import org.springframework.stereotype.Service;

@Service
public class FakeStoreCategoryImp implements CategoryService{

    @Override
    public String getAllCategories() {
        return "";
    }

    @Override
    public String getProductinCategory(Long categoryId) {
        return "";
    }
}
