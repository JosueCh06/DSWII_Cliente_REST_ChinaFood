package com.chinafood.cliente.entity;

public class IngredientePlatillo {

	private IngredientePlatilloPK id;
	private Platillo platillo;
	private Ingrediente ingrediente;

	public IngredientePlatilloPK getId() {
		return id;
	}

	public void setId(IngredientePlatilloPK id) {
		this.id = id;
	}

	public Platillo getPlatillo() {
		return platillo;
	}

	public void setPlatillo(Platillo platillo) {
		this.platillo = platillo;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
}
