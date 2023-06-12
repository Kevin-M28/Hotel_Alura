package com.hotelAlura.clases;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_res;
	@Temporal(TemporalType.DATE)
	private Date fecha_entrada;
	@Temporal(TemporalType.DATE)
	private Date fecha_salida;
	@Column
	private Double valor;
	@Column
	private String forma_pago;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	
	public Reserva() {
		this.fecha_entrada = new Date();
		this.fecha_salida = new Date();
		this.valor = 0.0;
		this.forma_pago = "";
	}

	public Reserva(Date fecha_entrada, Date fecha_salida, Double valor, String forma_pago) {
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.valor = valor;
		this.forma_pago = forma_pago;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getForma_pago() {
		return forma_pago;
	}

	public void setForma_pago(String forma_pago) {
		this.forma_pago = forma_pago;
	}

	public Long getId_res() {
		return id_res;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
