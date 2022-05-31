package com.chinafood.cliente.entity;

import java.io.Serializable;
import java.util.Objects;

public class RolEnlacePK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idrol;
	private int idenlace;
	
	@Override
	public int hashCode() {
		return Objects.hash(idenlace, idrol);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RolEnlacePK other = (RolEnlacePK) obj;
		return idenlace == other.idenlace && idrol == other.idrol;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public int getIdenlace() {
		return idenlace;
	}

	public void setIdenlace(int idenlace) {
		this.idenlace = idenlace;
	}
}
