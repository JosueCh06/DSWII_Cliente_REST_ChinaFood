package com.chinafood.cliente.entity;

public class Detalle {

	private int codPlatillo;
	private String nomPlatillo;
	private double precio;
	private int cantidad;
	private String ruta;
	
	
	public int getCodPlatillo() {
		return codPlatillo;
	}
	public void setCodPlatillo(int codPlatillo) {
		this.codPlatillo = codPlatillo;
	}
	public String getNomPlatillo() {
		return nomPlatillo;
	}
	public void setNomPlatillo(String nomPlatillo) {
		this.nomPlatillo = nomPlatillo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getSubTotal() {
		return precio * cantidad;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
	
	
	
}
