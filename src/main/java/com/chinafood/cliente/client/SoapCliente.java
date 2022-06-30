package com.chinafood.cliente.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.cibertec.spring.soap.api.servicioplatillo.*;



@Service
public class SoapCliente {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;


	public PostPlatilloResponse savePlatillo(PostPlatilloRequest request) {
		template = new WebServiceTemplate(marshaller);
		PostPlatilloResponse data = (PostPlatilloResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}
	
	public UpdatePlatilloResponse updatePlatillo(UpdatePlatilloRequest request) {
		template = new WebServiceTemplate(marshaller);
		UpdatePlatilloResponse data = (UpdatePlatilloResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}
	
	
	public GetPlatillosResponse listPlatillos(GetPlatillosRequest request) {
		template = new WebServiceTemplate(marshaller);
		GetPlatillosResponse data = (GetPlatillosResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}

	public GetPlatilloResponse buscarPlatillo(GetPlatilloRequest request) {
		template = new WebServiceTemplate(marshaller);
		GetPlatilloResponse data = (GetPlatilloResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}
	
	public DeletePlatilloResponse eliminarPlatillo(DeletePlatilloRequest request) {
		template = new WebServiceTemplate(marshaller);
		DeletePlatilloResponse data = (DeletePlatilloResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}
	
	public GetCategoriasResponse listCategorias(GetCategoriasRequest request) {
		template = new WebServiceTemplate(marshaller);
		GetCategoriasResponse data = (GetCategoriasResponse) template.marshalSendAndReceive("http://localhost:8078/ws",
				request);
		return data;
	}
	
}
