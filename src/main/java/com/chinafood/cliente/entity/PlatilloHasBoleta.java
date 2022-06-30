package com.chinafood.cliente.entity;

import com.cibertec.spring.soap.api.servicioplatillo.Platillo;

public class PlatilloHasBoleta {

	private PlatilloHasBoletaPK pk;
	private Boleta boleta;
	private Platillo platillo;
	private double precio;
	private int cantidad;
	private double subTotal;

	public PlatilloHasBoletaPK getPk() {
		return pk;
	}

	public void setPk(PlatilloHasBoletaPK pk) {
		this.pk = pk;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public Platillo getPlatillo() {
		return platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
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
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}
	
}
