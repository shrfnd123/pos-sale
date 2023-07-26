package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/store-product")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }
    
    @GetMapping("/product-list")
    public ResponseEntity<List<Product>> getproduct() {
        List<Product> product = productService.getAllProduct();
        return ResponseEntity.ok(product);
    }

    @PutMapping(value = "/product/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateProduct(@PathVariable Integer id, @Valid @RequestBody Product updatedProduct) {
        boolean isUpdated = productService.updateProduct(id, updatedProduct);
        if (isUpdated) {
            Product updatedProduct1 = productService.getSProductById(id);
            if (updatedProduct1 != null) {
                return ResponseEntity.ok(updatedProduct1);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/product/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer id) {
        boolean isDeleted = productService.deleteProduct(id);
        if (isDeleted) {
            return ResponseEntity.ok("Product deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
   @GetMapping("/products/{id}")
   public ResponseEntity<List<Product>> getProductByCategory(@RequestParam("category_id") Integer categoryId) {
	    List<Product> products = (List<Product>) productService.findProductByCategoryId(categoryId);
	    if (products.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.ok(products);
	    }
	}
}

