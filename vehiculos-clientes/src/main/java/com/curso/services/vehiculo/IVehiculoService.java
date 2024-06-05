package com.curso.services.vehiculo;

import java.util.List;

import com.curso.model.Cliente;
import com.curso.model.Vehiculo;
/**
 * Interfaz que define los servicios relacionados con la entidad Vehiculo
 */
public interface IVehiculoService {
	/**
	 * Lista de todos los vehículos disponibles
	 * @return  Lista de vehículos
	 */
	List<Vehiculo> listAllVehicles();
	Vehiculo getVehiculoById(int id);
	Vehiculo getVehiculoByMatricula(String matricula);
	void deleteVehiculoById(int id);
	void updateVehiculoById(int id, String matricula);
	void createVehiculo(Vehiculo vehiculo, int idCliente);
	List<Vehiculo> getVehiculosByFabricante(String nombreFabricante);
	public Cliente getClienteByVehiculoId(int id);
}
