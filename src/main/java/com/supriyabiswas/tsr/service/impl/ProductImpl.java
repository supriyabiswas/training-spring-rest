package com.supriyabiswas.tsr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supriyabiswas.tsr.persistance.dao.ProductRepository;
import com.supriyabiswas.tsr.persistance.model.Product;
import com.supriyabiswas.tsr.service.ProductService;

@Service
public class ProductImpl implements ProductService {

	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product getProduct(Long productId) {
		return productRepository.findOne(productId);
	}

	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void updateProduct(Product product, Long productId) {
		if(product.getId()==productId){
			productRepository.save(product);
		}

	}

	@Override
	public void deleteProduct(Long productId) {
		productRepository.delete(productId);
	}

}
