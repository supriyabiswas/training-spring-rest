package com.supriyabiswas.tsr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.supriyabiswas.tsr.persistance.dao.UserRepository;
import com.supriyabiswas.tsr.persistance.model.Address;
import com.supriyabiswas.tsr.persistance.model.User;
import com.supriyabiswas.tsr.persistance.dao.AddressRepository;
import com.supriyabiswas.tsr.service.UserService;
import com.supriyabiswas.tsr.service.exception.UserNotFoundException;



@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AddressRepository addressRepository;


	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUser(Long userId) {
		User user = userRepository.findOne(userId);

		if (user == null) {
			throw new UserNotFoundException(userId);
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		user=userRepository.save(user);
	//	addressRepository.save(user.getAddresses());
/*		if(user!=null){
			for(Address address: user.getAddresses()){
				addressRepository.save(address);
			}
		}
*/	}

	@Override
	public void updateUser(User user, Long userId) {

		if (user.getId() == userId) {
			userRepository.save(user);
			addressRepository.save(user.getAddresses());
		}

	}

	@Override
	public void deleteUser(Long userId) {

		User user = userRepository.getOne(userId);

		addressRepository.delete(user.getAddresses());
		userRepository.delete(userId);
	}

}
