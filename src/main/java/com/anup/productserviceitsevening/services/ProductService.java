package com.anup.productserviceitsevening.services;

import com.anup.productserviceitsevening.dtos.ProductDto;
import com.anup.productserviceitsevening.models.Category;
import com.anup.productserviceitsevening.models.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product addProduct(
            Product product);

    Product getProductById( Long productId);

    Product updateProduct( Long productId, Product product);

    String deleteProduct( Long productId);
}
