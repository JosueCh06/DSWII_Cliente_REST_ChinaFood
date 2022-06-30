package com.chinafood.cliente.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.chinafood.cliente.client.SoapCliente;
import com.cibertec.spring.soap.api.servicioplatillo.Categoria;
import com.cibertec.spring.soap.api.servicioplatillo.DeletePlatilloRequest;
import com.cibertec.spring.soap.api.servicioplatillo.GetCategoriasRequest;
import com.cibertec.spring.soap.api.servicioplatillo.GetPlatilloRequest;
import com.cibertec.spring.soap.api.servicioplatillo.GetPlatillosRequest;
import com.cibertec.spring.soap.api.servicioplatillo.Platillo;
import com.cibertec.spring.soap.api.servicioplatillo.PostPlatilloRequest;
import com.cibertec.spring.soap.api.servicioplatillo.UpdatePlatilloRequest;


@Controller
@RequestMapping("/cliente/platillo")
public class PlatilloController {

	@Autowired
	private SoapCliente soapCliente;

	@RequestMapping("/")
	public String index(Model model) {
		GetCategoriasRequest requestC = new GetCategoriasRequest();
		List<Categoria> listaC = soapCliente.listCategorias(requestC).getLista();
		GetPlatillosRequest requestP = new GetPlatillosRequest();
		List<Platillo> listaP = soapCliente.listPlatillos(requestP).getLista();
		// Crear atributos
		model.addAttribute("platillos", listaP);
		model.addAttribute("catPlatillos", listaC);
		model.addAttribute("platillo", new Platillo());
		return "platillo";
	}
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Platillo bean, RedirectAttributes redirect) {
		if(bean.getId() == 0) {
			PostPlatilloRequest request = new PostPlatilloRequest();
			request.setPlatillo(bean);
			int resultado;
			resultado = soapCliente.savePlatillo(request).getSalida();
			if(resultado > 0) 
				redirect.addFlashAttribute("MENSAJE", "Platillo registrado");
			else
				redirect.addFlashAttribute("MENSAJE", "Error en el registro");
		}else {
			UpdatePlatilloRequest request = new UpdatePlatilloRequest();
			request.setPlatillo(bean);
			int resultado;
			resultado = soapCliente.updatePlatillo(request).getSalida();
			if(resultado > 0) 
				redirect.addFlashAttribute("MENSAJE", "Platillo actualizado");
			else
				redirect.addFlashAttribute("MENSAJE", "Error en la actualización");
		}
		return "redirect:/cliente/platillo/";
	}
	@RequestMapping("/eliminar")
	public String eliminar(@RequestParam("codigo") int cod, RedirectAttributes redirect) {
		DeletePlatilloRequest request = new DeletePlatilloRequest();
		request.setCodigo(cod);
		int resultado;
		resultado = soapCliente.eliminarPlatillo(request).getSalida();
		if(resultado > 0)
		    redirect.addFlashAttribute("MENSAJE","Platillo eliminado");
		else
			redirect.addFlashAttribute("MENSAJE","Error en la eliminación");                                                                        
		return "redirect:/cliente/platillo/";
	}
	
	@RequestMapping("/buscar")
	@ResponseBody
	public Platillo buscar(@RequestParam("codigo") int cod) {
		Platillo p = null;
		GetPlatilloRequest request=new GetPlatilloRequest();
		request.setCodigo(cod);
		p = soapCliente.buscarPlatillo(request).getPlatillo();
		return p;

	}


}
