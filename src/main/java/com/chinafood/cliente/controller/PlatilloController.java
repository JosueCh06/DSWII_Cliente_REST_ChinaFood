package com.chinafood.cliente.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chinafood.cliente.entity.CategoriaPlatillo;
import com.chinafood.cliente.entity.Platillo;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente/platillo")
public class PlatilloController {

	private String URL = "http://localhost:8094/";

	@RequestMapping("/")
	public String index(Model model) {
		// Crear objeto de la clase RestTemplate para acceder a la ruta del servicio
		RestTemplate rt = new RestTemplate();
		// Acceder al servicio con ruta "medicamento/listar"
		ResponseEntity<Platillo[]> responseMed = rt.getForEntity(URL + "platillo/listar", Platillo[].class);
		// Acceder al servicio con ruta "laboratorio/listar"
		ResponseEntity<CategoriaPlatillo[]> responseLab = rt.getForEntity(URL + "categoriaPlatillo/listar",
				CategoriaPlatillo[].class);
		// Crear atributos
		model.addAttribute("platillos", responseMed.getBody());
		model.addAttribute("catPlatillos", responseLab.getBody());
		model.addAttribute("platillo", new Platillo());
		return "platillo";
	}

	@RequestMapping("/grabar")
	public String grabar(@ModelAttribute Platillo p, RedirectAttributes redirect) {
		try {
			RestTemplate rt = new RestTemplate();
			// Serializar
			Gson gson = new Gson();
			String json = gson.toJson(p);
			
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> request=new HttpEntity<String>(json,headers);
			if(p.getIdPlatillo() == 0) {
				rt.postForObject(URL+"platillo/registrar", request, String.class);
				redirect.addFlashAttribute("MENSAJE", "Platillo registrado");
			}
			else {
				rt.put(URL+"platillo/actualizar", request, String.class);
				redirect.addFlashAttribute("MENSAJE", "Platillo actualizado");
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/cliente/platillo/";
	}

}
