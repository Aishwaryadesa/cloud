package com.yourcompany.ecommerce.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.yourcompany.ecommerce.model.Product;

@Service
public class ProductService {

	

	    private static final String API_BASE_URL = "https://api.shoppernest.com";
	    private static final String API_KEY = "your_api_key";
	    private final RestTemplate restTemplate;

	    public ProductService(RestTemplate restTemplate) {
	        this.restTemplate = restTemplate;
	    }

	    public Product createProduct(Product product) {
	        String url = API_BASE_URL + "/products";
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + API_KEY);
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<Product> request = new HttpEntity<>(product, headers);
	        ResponseEntity<Product> response = restTemplate.postForEntity(url, request, Product.class);
	        return response.getBody();
	    }

	    public Product getProductById(Long productId) {
	        String url = API_BASE_URL + "/products/" + productId;
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + API_KEY);
	        HttpEntity<?> request = new HttpEntity<>(headers);
	        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
	        return response.getBody();
	    }

	    public Product updateProduct(Long productId, Product updatedProduct) {
	        String url = API_BASE_URL + "/products/" + productId;
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + API_KEY);
	        headers.setContentType(MediaType.APPLICATION_JSON);
	        HttpEntity<Product> request = new HttpEntity<>(updatedProduct, headers);
	        ResponseEntity<Product> response = restTemplate.exchange(url, HttpMethod.PUT, request, Product.class);
	        return response.getBody();
	    }

	    public void deleteProduct(Long productId) {
	        String url = API_BASE_URL + "/products/" + productId;
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Authorization", "Bearer " + API_KEY);
	        HttpEntity<?> request = new HttpEntity<>(headers);
	        restTemplate.exchange(url, HttpMethod.DELETE, request, Void.class);
	    }
	}

