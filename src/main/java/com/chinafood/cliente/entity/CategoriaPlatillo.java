package com.chinafood.cliente.entity;

public class CategoriaPlatillo {

	private int idCategoria;
	private String descripcionCategoria;
	
	public CategoriaPlatillo() {
	}
	public CategoriaPlatillo(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getDescripcionCategoria() {
		return descripcionCategoria;
	}
	public void setDescripcionCategoria(String descripcionCategoria) {
		this.descripcionCategoria = descripcionCategoria;
	}

}
