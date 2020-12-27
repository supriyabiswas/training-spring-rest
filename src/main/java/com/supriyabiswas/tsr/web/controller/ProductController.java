package com.supriyabiswas.tsr.web.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supriyabiswas.tsr.persistance.model.Product;
import com.supriyabiswas.tsr.service.ProductService;


//@RestController
@RestController @CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)           
	public void addProduct(@RequestBody Product product) {
		System.out.println(product.getDescription()+"------"+product.getName()+"==========="+product.getPrice());
		productService.addProduct(product);
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		System.out.println("being called");
		return productService.getAllProducts();
	}
	
//	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	@DeleteMapping("/products/{Id}")
	public void deleteProduct(@PathVariable Long Id) {
		productService.deleteProduct(Id);
	}
	
	@PutMapping("/products/{productId}")
	public void updateProduct(@RequestBody Product product, @PathVariable Long productId) {
		productService.updateProduct(product, productId);
	}

	//@GetMapping("/products/{Id}")
	@GetMapping(value="/products/{Id}")/*For @GetMapping/@PutMapping/@DeleteMapping URL is mentioned along with 'value' or without value  
	it will work as commented one and active one above
	*/
	
	/* PathVariable can be defined in 3 different ways
	 * 1. if value is not mentioned like, getProduct(@PathVariable Long productId), parameter name 'productId' must match with the Parameter defined  
	 *  in the URL here it is {Id}. In this case it will not work as both are different. We need to change either of the name to keep it same.
	 * 2. If defined PathVriaable parameter name is different from URL parameter, we can put the PathVariable name in the following way
	 *    either getProduct(@PathVariable(value="Id") Long productId) or getProduct(@PathVariable("Id") Long productId) to keep the parameter name same. 
	 */
	//@RequestMapping(value = "/products/{Id}", method = RequestMethod.GET)
	//public Product getProduct(@PathVariable(value="Id") Long Id) {
//	public Product getProduct(@PathVariable("Id") Long productId) {
	
	public Product getProduct(@PathVariable(value="Id") Long productId) {
		return productService.getProduct(productId);
	}
	
}
