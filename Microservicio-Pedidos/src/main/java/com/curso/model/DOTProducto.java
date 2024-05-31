package com.curso.model;

public class DOTProducto {

	private int codProducto;
	private String nombre;
	private int stock;
	private double precio;
	
	
	public DOTProducto() {
		super();
	}

	public DOTProducto(int codProducto) {
		super();
		this.codProducto = codProducto;
	}

	public DOTProducto(String nombre, int stock, double precio) {
		super();
		this.nombre = nombre;
		this.stock = stock;
		this.precio = precio;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
