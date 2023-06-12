package com.hotelAlura.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
@DiscriminatorValue("Administrador")
public class Administrador extends Usuario {
	
	@Column(length = 100)
	private String nombre;
	

	public Administrador() {
		super();
	}

	public Administrador(String nombre, String n_usuario, String contra) {
		super(n_usuario,contra);
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Administrador [nombre=" + nombre + ", getUsuario()=" + getUsuario() + ", getContrasenna()="
				+ getContrasenna() + ", getId_usuarios()=" + getId_usuarios() + "]";
	}
	
	
	
}
