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

import com.chinafood.cliente.entity.CategoriaProveedor;
import com.chinafood.cliente.entity.Ingrediente;
import com.chinafood.cliente.entity.Proveedor;
import com.google.gson.Gson;

@Controller
@RequestMapping("/cliente/proveedor")
public class ProveedorController {

	//URL
		private String URL="http://localhost:8094/";
		
		@RequestMapping("/")
		public String index(Model model) {
			//crear objeto de la clase RestTemplate para acceder a la ruta de un servicio
			RestTemplate rt=new RestTemplate();
			//acceder al servicio con ruta "medicamento/listar"
			ResponseEntity<Proveedor[]>responseIngr=rt.getForEntity(URL+"proveedor/listar", Proveedor[].class);
			//acceder al servicio con ruta "laboratorio/listar"
			ResponseEntity<CategoriaProveedor[]>responseProv=rt.getForEntity(URL+"categoriaProveedor/listar", CategoriaProveedor[].class);
			
			//crear atributos
			model.addAttribute("proveedores",responseIngr.getBody());
			model.addAttribute("categorias",responseProv.getBody());
			model.addAttribute("proveedor",new Proveedor());
			
			return "proveedor";
		}
		
		
		@RequestMapping("/grabar")
		public String grabar(@ModelAttribute Proveedor prov, RedirectAttributes redirect) {
			try {
				RestTemplate rt = new RestTemplate();
				//serializar
				Gson gson=new Gson();
				String json=gson.toJson(prov);	
				
				HttpHeaders headers=new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				HttpEntity<String> request=new HttpEntity<String>(json,headers);
				if(prov.getIdProveedor()==0) {
					rt.postForObject(URL+"proveedor/registrar", request, String.class);
					redirect.addFlashAttribute("MENSAJE","Proveedor registrado");
				}
				else {
					rt.put(URL+"proveedor/actualizar", request, String.class);
					redirect.addFlashAttribute("MENSAJE","Proveedor actualizado");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "redirect:/cliente/proveedor/";
		}
		
}
