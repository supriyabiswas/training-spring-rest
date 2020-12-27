package com.supriyabiswas.tsr.service;

import java.util.List;

import com.supriyabiswas.tsr.persistance.model.Product;

public interface ProductService {
	List<Product> getAllProducts();

	Product getProduct(Long productId);

	void addProduct(Product product);

	void updateProduct(Product product, Long productId);

	void deleteProduct(Long productId);
}