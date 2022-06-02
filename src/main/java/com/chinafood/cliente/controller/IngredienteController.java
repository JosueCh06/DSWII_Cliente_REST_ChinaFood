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

import com.chinafood.cliente.entity.Ingrediente;
import com.chinafood.cliente.entity.Proveedor;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente/ingrediente")
public class IngredienteController {

	//URL
		private String URL="http://localhost:8094/";
		
		@RequestMapping("/")
		public String index(Model model) {
			//crear objeto de la clase RestTemplate para acceder a la ruta de un servicio
			RestTemplate rt=new RestTemplate();
			//acceder al servicio con ruta "medicamento/listar"
			ResponseEntity<Ingrediente[]>responseIngr=rt.getForEntity(URL+"ingrediente/listar", Ingrediente[].class);
			//acceder al servicio con ruta "laboratorio/listar"
			ResponseEntity<Proveedor[]>responseProv=rt.getForEntity(URL+"proveedor/listar", Proveedor[].class);
			
			//crear atributos
			model.addAttribute("ingredientes",responseIngr.getBody());
			model.addAttribute("proveedores",responseProv.getBody());
			model.addAttribute("ingrediente",new Ingrediente());
			
			return "ingrediente";
		}
		
		
		@RequestMapping("/grabar")
		public String grabar(@ModelAttribute Ingrediente ingr, RedirectAttributes redirect) {
			try {
				RestTemplate rt = new RestTemplate();
				//serializar
				Gson gson=new Gson();
				String json=gson.toJson(ingr);	
				
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request=new HttpEntity<String>(json,headers);
				if(ingr.getIdIngrediente()==0) {
					rt.postForObject(URL+"ingrediente/registrar", request, String.class);
					redirect.addFlashAttribute("MENSAJE","Ingrediente registrado");
				}
				else {
					rt.put(URL+"ingrediente/actualizar", request, String.class);
					redirect.addFlashAttribute("MENSAJE","Ingrediente actualizado");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/cliente/ingrediente/";
		}
		
}
