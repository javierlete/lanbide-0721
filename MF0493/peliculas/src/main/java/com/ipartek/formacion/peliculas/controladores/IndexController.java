package com.ipartek.formacion.peliculas.controladores;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/prueba")
	public String prueba() {
		return "prueba";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
