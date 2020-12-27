package com.supriyabiswas.tsr.persistance.dao;

import org.springframework.data.repository.CrudRepository;

import com.supriyabiswas.tsr.persistance.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
