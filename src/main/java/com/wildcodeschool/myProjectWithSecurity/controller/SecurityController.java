package com.wildcodeschool.myProjectWithSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	@GetMapping("/")
	public String welcome() {
		return "Welcome to the Shield !";
	}
	
	@GetMapping("/avengers/assemble")
	public String avenger() {
		return "Avengers...Assemble";
	}
	
	@GetMapping("/secret-bases")
	public String secretBases() {
		return "List of secret bases : Biarritz, Bordeaux, la Loupe, Lille, Lyon, Marseille, Nantes, orleans, Paris, Reims, Strasbourg, Toulouse, Tours";
	}
}
