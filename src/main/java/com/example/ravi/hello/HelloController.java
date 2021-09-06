package com.example.ravi.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello") //get method(by default)
	public String sayHii() {
		return "Hii";
	}
	
}
