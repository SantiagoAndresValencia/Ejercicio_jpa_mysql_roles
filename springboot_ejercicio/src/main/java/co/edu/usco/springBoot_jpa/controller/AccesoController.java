package co.edu.usco.springBoot_jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AccesoController {

	@GetMapping("/")
	public String inicio() {
		return "redirect:/productos";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/403")
	public String accesoDenegado() {
		return "403";
	}

}
