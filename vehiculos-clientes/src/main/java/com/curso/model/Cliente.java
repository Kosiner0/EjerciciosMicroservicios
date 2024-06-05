package com.curso.model;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	/**
	 * Identificados único del Cliente
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String apellido;
	/**
	 * Representa una lista de Vehículos asociados a este Cliente
	 * Esta relación administra una a asociación de uno a muchos, donde un Cliente
	 * puede tener varios vehículos
	 */
	
	@OneToMany(mappedBy = "cliente")
	@JsonManagedReference
	private List<Vehiculo> vehiculos;
	
	public Cliente() {
		super();
	}
	
	
	public Cliente(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}

	/**
	 * Constructor para crear un objeto Cliente completamente poblado
	 * @param id			Identificador único del Cliente
	 * @param nombre		Nombre del Cliente
	 * @param apellido		Apellido del Cliente
	 * @param vehiculos		Lista de Vehiculos asociados a este CLiente
	 */
	public Cliente(int id, String nombre, String apellido, List<Vehiculo> vehiculos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.vehiculos = vehiculos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public List<Vehiculo> getVehiculos() {
		return vehiculos;
	}
	public void setVehiculos(List<Vehiculo> vehiculos) {
		this.vehiculos = vehiculos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return id == other.id;
	}
	
}
