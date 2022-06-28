package com.spring.SpringBootTutorial.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
//	@RequestMapping(value = "/", method = RequestMethod.GET)   // Instead of using this for get mPPING, USE NEXT LINE
	
	 
	@GetMapping("/")
	public String HelloWorld() {
		return "Welcome to Deep Priyanka Zone";
	}
	
}
