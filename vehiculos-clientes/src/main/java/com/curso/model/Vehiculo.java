package com.curso.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="vehiculos")
public class Vehiculo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name="id_cliente")
//	private int idCliente;
	private int id;
	private String matricula;
	private String fabricante;
	private String modelo;
	@ManyToOne
	@JoinColumn(name = "id_cliente")
    @JsonBackReference
	private Cliente cliente;
	
	
	public Vehiculo() {
		super();
	}
	public Vehiculo(String matricula, String fabricante, String modelo, Cliente cliente) {
		this.matricula = matricula;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cliente = cliente;
	}
	public Vehiculo(int id, String matricula, String fabricante, String modelo, Cliente cliente) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.cliente = cliente;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	
	
}
