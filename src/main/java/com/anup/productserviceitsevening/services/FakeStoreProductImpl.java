package com.anup.productserviceitsevening.services;

import com.anup.productserviceitsevening.dtos.ProductDto;
import com.anup.productserviceitsevening.models.Category;
import com.anup.productserviceitsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FakeStoreProductImpl implements ProductService {
    private RestTemplate restTemplate;
    FakeStoreProductImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }


    @Override
    public List<Product> getAllProducts() {
        ProductDto[] productDtos = restTemplate.getForObject("https://fakestoreapi.com/products", ProductDto[].class);
        if (productDtos == null) {
            System.out.println("No products found.");
            return List.of();
        }

        System.out.println("Fetched " + productDtos.length + " products.");
        return Arrays.stream(productDtos)
                .map(this::convertProductDtoToProduct)
                .collect(Collectors.toList());
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    private Product convertProductDtoToProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setTitle(productDto.getTitle());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImage());

        Category category = new Category();
        category.setDescription(productDto.getCategory());
        product.setCategory(category);

        return product;



    }
    @Override
    public Product getProductById(Long productId) {
        ProductDto productDto=restTemplate.getForObject("https://fakestoreapi.com/products/" + productId, ProductDto.class);
        //convert fakedto to actual object

        return convertProductDtoToProduct(productDto);
    }

    @Override
    public Product updateProduct(Long productId, Product product) {
        return null;
    }

    @Override
    public String deleteProduct(Long productId) {
        return "";
    }
}
