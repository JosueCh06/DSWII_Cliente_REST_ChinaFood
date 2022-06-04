package com.chinafood.cliente.entity;

public class Platillo {

	private int idPlatillo;
	private String descripcion;
	private double precio;
	private CategoriaPlatillo categoria;
	
	public int getIdPlatillo() {
		return idPlatillo;
	}
	public void setIdPlatillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public CategoriaPlatillo getCategoria() {
		return categoria;
	}
	public void setCategoria(CategoriaPlatillo categoria) {
		this.categoria = categoria;
	}
	public Platillo() {
		
	}
	public Platillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}
}
