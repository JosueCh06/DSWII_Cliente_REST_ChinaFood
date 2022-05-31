package com.chinafood.cliente.entity;

public class Proveedor {

	private int idProveedor;
	private String nombre;
	private String representante;
	private String celular;
	private String direccion;
	private CategoriaProveedor categoriaProveedor;
	
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRepresentante() {
		return representante;
	}
	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public CategoriaProveedor getCategoriaProveedor() {
		return categoriaProveedor;
	}
	public void setCategoriaProveedor(CategoriaProveedor categoriaProveedor) {
		this.categoriaProveedor = categoriaProveedor;
	}
	
}
