package com.yourcompany.ecommerce.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.yourcompany.ecommerce.model.Product;
import com.yourcompany.ecommerce.service.ProductService;
@RestController
@RequestMapping("/products")
public class ProductController {


	    private final ProductService productService;

	    public ProductController(ProductService productService) {
	        this.productService = productService;
	    }

	    @PostMapping
	    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
	        Product createdProduct = productService.createProduct(product);
	        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	    }

	    @GetMapping("/{productId}")
	    public ResponseEntity<Product> getProduct(@PathVariable Long productId) {
	        Product product = productService.getProductById(productId);
	        return ResponseEntity.ok(product);
	    }

	    @PutMapping("/{productId}")
	    public ResponseEntity<Product> updateProduct(@PathVariable Long productId, @RequestBody Product updatedProduct) {
	        Product product = productService.updateProduct(productId, updatedProduct);
	        return ResponseEntity.ok(product);
	    }

	    @DeleteMapping("/{productId}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
	        productService.deleteProduct(productId);
	        return ResponseEntity.noContent().build();
	    }
	}

