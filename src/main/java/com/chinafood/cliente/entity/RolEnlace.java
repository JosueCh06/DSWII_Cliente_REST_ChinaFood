package com.chinafood.cliente.entity;

public class RolEnlace {

	private RolEnlacePK id;
	private Rol rol;
	private Enlace enlace;

	/*
	 * 
	 * 
	 * 
	 * 
	 */

	public RolEnlacePK getId() {
		return id;
	}

	public void setId(RolEnlacePK id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Enlace getEnlace() {
		return enlace;
	}

	public void setEnlace(Enlace enlace) {
		this.enlace = enlace;
	}

}
