package com.supriyabiswas.tsr.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@RequestMapping(value = "/welcome")
	public String welcome() {

		return "welcome to ibm spring rest training";
	}
}
