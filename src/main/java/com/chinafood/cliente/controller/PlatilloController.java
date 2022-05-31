package com.chinafood.cliente.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.chinafood.cliente.entity.CategoriaPlatillo;
import com.chinafood.cliente.entity.Platillo;

@Controller
@RequestMapping("/cliente/platillo")
public class PlatilloController {
	
	private String URL = "http://localhost:8094/";
	
	@RequestMapping("/")
	public String index(Model model) {
		// Crear objeto de la clase RestTemplate para acceder a la ruta del servicio
		RestTemplate rt = new RestTemplate();
		// Acceder al servicio con ruta "medicamento/listar"
		ResponseEntity<Platillo[]> responseMed =	rt.getForEntity(URL + "platillo/listar", Platillo[].class);
		// Acceder al servicio con ruta "laboratorio/listar"
		ResponseEntity<CategoriaPlatillo[]> responseLab =	rt.getForEntity(URL + "categoriaPlatillo/listar", CategoriaPlatillo[].class);
		// Crear atributos
		model.addAttribute("platillos", responseMed.getBody());
		model.addAttribute("catPlatillos", responseLab.getBody());
		//model.addAttribute("medicamento", new Platillo());
		return "platillo";
	}

}
