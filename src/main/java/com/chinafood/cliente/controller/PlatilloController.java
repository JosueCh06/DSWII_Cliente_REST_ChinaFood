package com.chinafood.cliente.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
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
	public String grabar(@RequestParam("descripcion") String desc, @RequestParam("codigo") int cod,
			@RequestParam("precio") double precio, @RequestParam("categoria") int categoria,
			@RequestParam("imagen") MultipartFile file, RedirectAttributes redirect) {
		try {
			String folder = "src//main//resources//static//resources//cargas//platillos//";
			if (!file.isEmpty()) {
				try {
					Platillo bean = new Platillo();
					bean.setDescripcion(desc);
					bean.setPrecio(precio);
					bean.setCategoria(new CategoriaPlatillo(categoria));
					String ruta = "/resources/cargas/platillos/";

					byte[] bytes = file.getBytes();
					Path path = Paths.get(folder + file.getOriginalFilename());
					Files.write(path, bytes);

					bean.setLinkImagen(ruta + file.getOriginalFilename());

					// Serializar
					Gson gson = new Gson();
					String json = gson.toJson(bean);
					//
					RestTemplate rt = new RestTemplate();
					HttpHeaders headers = new HttpHeaders();
					headers.setContentType(MediaType.APPLICATION_JSON);
					HttpEntity<String> request = new HttpEntity<>(json, headers);
					if (bean.getIdPlatillo() != 0) {
						rt.put(URL + "platillo/actualizar", request, String.class);
						redirect.addFlashAttribute("MENSAJE", "Platillo Actualizado");
					} else {
						String x = rt.postForObject(URL + "platillo/registrar", request, String.class);
						redirect.addFlashAttribute("MENSAJE", "Platillo Registrado");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("MENSAJE", "Error en la grabación");
			e.printStackTrace();
		}
		return "redirect:/cliente/platillo/";
	}

}
