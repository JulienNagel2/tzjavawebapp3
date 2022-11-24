package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		String myMsg = "Hello JNG v2";
		System.out.println("This is an update to pass the test. myMsg = " + myMsg);
		String msgToDisplay = "Greetings from Spring Boot + Tanzu!";
		return  msgToDisplay;
	}

}