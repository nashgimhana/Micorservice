package com.micro.productservice.productservice.service;

import com.micro.productservice.productservice.dto.ProductRequest;
import com.micro.productservice.productservice.dto.ProductResponse;
import com.micro.productservice.productservice.model.Product;
import com.micro.productservice.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product= Product.builder().name(productRequest.getName()).description(productRequest.getDescription())
                .price(productRequest.getPrice()).build();

        productRepository.save(product);
        log.info("Product "+product.getId()+" is saved");
    }


    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();

        return products.stream().map(this::mapTOProductResponse).collect(Collectors.toList());
    }

    private ProductResponse mapTOProductResponse(Product product) {
        return ProductResponse.builder().id(product.getId()).name(product.getName()).price(product.getPrice()).description(product.getDescription()).build();
    }
}
