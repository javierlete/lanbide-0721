package com.ipartek.formacion.springmvc.controladores;

import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class SaludarController {
	@GetMapping("/saludo")
	public String saludo(@RequestParam(defaultValue = " a todos") String nombre, Model modelo) {
		modelo.addAttribute("texto", "¿Qué tal estás " + nombre + "?");
		return "saludo";
	}

	@GetMapping("/sumar")
	@ResponseBody
	public int sumar(int a, int b) {
		return a + b;
	}
}
