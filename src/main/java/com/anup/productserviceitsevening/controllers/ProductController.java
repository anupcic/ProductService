package com.anup.productserviceitsevening.controllers;

import com.anup.productserviceitsevening.dtos.GetSingleProductResponseDto;
import com.anup.productserviceitsevening.dtos.ProductDto;
import com.anup.productserviceitsevening.models.Product;
import com.anup.productserviceitsevening.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @PostMapping()
    public String addProduct(@RequestBody ProductDto productDto){
        return "Product Added  with" + productDto.toString();
    }
    //@GetMapping("/{productId}")
//    public GetSingleProductResponseDto getSingleProduct(@PathVariable("productId") Long productId){
//        GetSingleProductResponseDto getSingleProductResponseDto = new GetSingleProductResponseDto();
//        getSingleProductResponseDto.setProduct(productService.getSingleProduct(productId));
//        return getSingleProductResponseDto;
//    }
//    public Product getSingleProduct(@PathVariable Long productId){
//        return productService.getSingleProduct(productId);
//    }---working
//    public ResponseEntity<Product> getSingleProduct(@PathVariable Long productId){
//        HttpHeaders headers = new HttpHeaders();
//        String header = "your-auth-token-value--anup"; // replace with your actual token
//        headers.add("auth-token", header);
//        ResponseEntity<Product> response=new ResponseEntity(productService.getSingleProduct(productId),headers, HttpStatus.OK);
//        return response;
//
//    }
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable Long productId){
        Product product= productService.getProductById(productId);

        //ResponseEntity<Product> responseEntity ;
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PutMapping("/{productId}")
    public Product updateProduct( @PathVariable("productId") Long productId,@RequestBody Product product){
        return productService.updateProduct(productId,product);
    }
    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable("productId") Long productId){
        return "Product Deleted for id: " + productId;
    }
}
