package com.chinafood.cliente.entity;

import java.util.Objects;

public class IngredientePlatilloPK {
	
	private int idIngrediente;
	private int idPlatillo;
	
	@Override
	public int hashCode() {
		return Objects.hash(idIngrediente, idPlatillo);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IngredientePlatilloPK other = (IngredientePlatilloPK) obj;
		return idPlatillo == other.idPlatillo && idIngrediente == other.idIngrediente;
	}
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */
	
	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public int getIdPlatillo() {
		return idPlatillo;
	}

	public void setIdPlatillo(int idPlatillo) {
		this.idPlatillo = idPlatillo;
	}
	
	
}
