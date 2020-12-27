package com.supriyabiswas.tsr.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.supriyabiswas.tsr.persistance.model.Address;


public interface AddressRepository extends JpaRepository<Address, Long>{

}
