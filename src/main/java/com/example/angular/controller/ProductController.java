package com.example.angular.controller;


import com.example.angular.controller.dto.ProductPostReqBody;
import com.example.angular.controller.dto.ProductPutReqBody;
import com.example.angular.persistence.Product;
import com.example.angular.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
//@CrossOrigin(origins = "/*")
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ResponseStatus(OK)
    @GetMapping("/all")
    public @ResponseBody List<Product> listAll() {
        return productService.listAll();
    }

    @ResponseStatus(OK)
    @GetMapping("/{id}")
    public Product findById(final @PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody final ProductPostReqBody productPostReqBody) {
        return new ResponseEntity<Product>(productService.save(productPostReqBody), CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> update(@RequestBody final ProductPutReqBody productPutReqBody) {
        return new ResponseEntity<>(productService.update(productPutReqBody), ACCEPTED);
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("delete/{id}")
    public void delete(final @PathVariable Long id) {
        productService.delete(id);
    }
}
