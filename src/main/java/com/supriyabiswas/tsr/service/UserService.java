package com.supriyabiswas.tsr.service;

import java.util.List;

import com.supriyabiswas.tsr.persistance.model.User;

public interface UserService {

	List<User> getAllUsers();

	User getUser(Long userId);

	void addUser(User user);

	void updateUser(User user, Long userId);

	void deleteUser(Long userId);
}
