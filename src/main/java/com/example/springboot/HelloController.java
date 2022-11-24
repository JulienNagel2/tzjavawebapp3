package com.example.springboot;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		String myMsg = "Hello JNG";
		System.out.println("myMsg = " + myMsg);
		String msgToDisplay = "Greetings from Spring Boot + Tanzu!" + myMsg;
		return  msgToDisplay;
	}

}