package com.anup.productserviceitsevening.services;

import com.anup.productserviceitsevening.dtos.ProductDto;
import com.anup.productserviceitsevening.models.Category;
import com.anup.productserviceitsevening.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestTemplateAdapter;

import java.util.ArrayList;
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

        List<Product> response=new ArrayList<>();
        for (ProductDto productDto : productDtos) {
            response.add(convertProductDtoToProduct(productDto));
        }
        return response;
//        return Arrays.stream(productDtos)
//                .map(this::convertProductDtoToProduct)
//                .collect(Collectors.toList());
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


        ProductDto productDto=new ProductDto();

        productDto.setTitle(product.getTitle());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setDescription(product.getDescription());

        if (product.getCategory() != null) {
            productDto.setCategory(product.getCategory().getName());
        }

        //RequestCallback requestCallback = restTemplate.httpEntityCallback(product, ProductDto.class);
        //HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor<>(ProductDto.class, restTemplate.getMessageConverters());
//
        RequestCallback requestCallback = restTemplate.httpEntityCallback(productDto, ProductDto.class);
        HttpMessageConverterExtractor<ProductDto> responseExtractor = new HttpMessageConverterExtractor<>(ProductDto.class, restTemplate.getMessageConverters());

        // Execute the PUT request
        String url = "https://fakestoreapi.com/products/" + productId; // Corrected URL
        ProductDto response = restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor);

        // Convert response ProductDto to Product
        return convertProductDtoToProduct(response);

    }

    @Override
    public String deleteProduct(Long productId) {
        return "";
    }
}
