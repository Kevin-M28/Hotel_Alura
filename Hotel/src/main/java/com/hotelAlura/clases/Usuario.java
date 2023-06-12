package com.hotelAlura.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_usuarios;
	
	@Column(length = 100)
	private String usuario;
	
	@Column (length = 100)
	private String contrasenna;

	public Usuario() {
	}

	public Usuario(String usuario, String contrasenna) {
		this.usuario = usuario;
		this.contrasenna = contrasenna;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

	public long getId_usuarios() {
		return id_usuarios;
	}
	
}
