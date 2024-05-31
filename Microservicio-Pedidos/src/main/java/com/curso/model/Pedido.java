package com.curso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codPedido;
	private String nombre;
	private int cantidad;
	private int codProd;
	
	
	public Pedido() {
		super();
	}

	public Pedido(int codPedido) {
		super();
		this.codPedido = codPedido;
	}

	public Pedido(String nombre, int cantidad, int codProd) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.codProd = codProd;
	}

	public int getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(int codPedido) {
		this.codPedido = codPedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getCodProd() {
		return codProd;
	}

	public void setCodProd(int codProd) {
		this.codProd = codProd;
	}
	
	
	
}
