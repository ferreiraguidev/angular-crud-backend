package com.example.angular.service;


import com.example.angular.controller.dto.ProductPostReqBody;
import com.example.angular.controller.dto.ProductPutReqBody;
import com.example.angular.persistence.Product;
import com.example.angular.repository.ProductRepository;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(final ProductPostReqBody productPostReqBody) {
        val product = Product.builder()
                .id(productPostReqBody.getId())
                .name(productPostReqBody.name)
                .category(productPostReqBody.getCategory())
                .build();
        return productRepository.save(product);
    }

    public Product update(final ProductPutReqBody productPutReqBody) {
        val byId = productRepository.findById(productPutReqBody.getId());

        if (byId.isEmpty()) {
            throw new IllegalArgumentException("ID inexistente!");
        }

        val product = Product.builder()
                .id(productPutReqBody.getId())
                .name(productPutReqBody.getName())
                .category(productPutReqBody.getCategory())
                .build();
        return productRepository.save(product);
    }

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product findById(final Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Customize exception!"));
    }

    public Product findByName(final String name) {
        return productRepository.findByName(name);

    }

    public void delete(final Long id) {
        productRepository.deleteById(id);
    }
}
