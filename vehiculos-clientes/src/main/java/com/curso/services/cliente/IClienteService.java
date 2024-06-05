package com.curso.services.cliente;

import java.util.List;

import com.curso.model.Cliente;
import com.curso.model.Vehiculo;

/**
 * Interfaz que define los servicios relacionados con la entidad CLiente
 */
public interface IClienteService {
	List<Cliente> listAllClients();
	
	/**
	 * Obtiene una lista de todos los vehículos que son propiedad de un cliente específico
	 * @param id Identificador único del Cliente
	 * @return	Lista de vehículos propiedad del Cliente
	 */
	List<Vehiculo> listAllVehiclesOwnedByClient(int id);	
	Cliente getClienteById(int id);
	public void deleteClienteById(int id);
	public void updateClienteById(int id, String nombre, String apellido);
	public void createClient(Cliente cliente);
	public List<Cliente> getClientesByApellido(String apellido);

}
