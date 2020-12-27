package com.supriyabiswas.tsr.web.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supriyabiswas.tsr.persistance.model.ApiResponse;
import com.supriyabiswas.tsr.persistance.model.User;
import com.supriyabiswas.tsr.service.UserService;


@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<com.supriyabiswas.tsr.persistance.model.User> getAllUsers() {
//	public List<ApiResponse> findUsers() {

		return userService.getAllUsers();
	//	return new List<ApiResponse>(HttpStatus.OK.value(), "User fetched successfully.",userService.getAllUsers());
	}

	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	public ApiResponse findUser(@PathVariable("userId") Long userId) {

		return new ApiResponse(HttpStatus.OK.value(), "User fetched successfully.",userService.getUser(userId));
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)           
	public void addUser(@RequestBody com.supriyabiswas.tsr.persistance.model.User user) {
		userService.addUser(user);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.CREATED)
	public void updateUser(@RequestBody User user, @PathVariable Long userId) {
		userService.updateUser(user, userId);
	}

	@RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	/*
	 * @RequestMapping(value = "/user", method = RequestMethod.GET) public User
	 * findUser() {
	 * 
	 * User user = new User(); user.setId(1L); user.setName("Manoj..");
	 * 
	 * return user; }
	 * 
	 * @RequestMapping(value = "/users", method = RequestMethod.GET) public
	 * List<User> findUsers() {
	 * 
	 * List<User> users = new ArrayList<>();
	 * 
	 * User user1 = new User(); user1.setId(1L); user1.setName("Manoj..");
	 * 
	 * User user2 = new User(); user2.setId(2L); user2.setName("Manoj.2.");
	 * 
	 * users.add(user1); users.add(user2);
	 * 
	 * return users; }
	 */

}
