package com.curso.services.vehiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ClienteDao;
import com.curso.dao.VehiculoDao;
import com.curso.model.Cliente;
import com.curso.model.Vehiculo;
/**
 * Servicio que implementa las operaciones relacionadas con la entidad Vehiculo
 * 
 */

@Service
public class VehiculoService implements IVehiculoService {
	//Inyección de dependencia para el dao de vehículos
	@Autowired
	private VehiculoDao dao;
	//Inyección de dependencia para el dao de clientes
	@Autowired
	private ClienteDao clienteDao;
	
	/**
	 * Recupera la lista de todos los vehículos
	 * @return Lista de vehículos
	 */
	@Override
	public List<Vehiculo> listAllVehicles() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Vehiculo getVehiculoById(int id) {			
		return dao.findById(id).get();
	}

	@Override
	public Vehiculo getVehiculoByMatricula(String matricula) {
		return dao.getVehiculoByMatricula(matricula);
	}

	@Override
	public void deleteVehiculoById(int id) {
		dao.deleteById(id);
	}
 /**
  * 
  *  En el proceso de transformación del id se utiliza el algoritmo de multiplicar por 345 para 
  *  obtener el valor deseado
 
	@Override
	public void updateVehiculoById(int id, String matricula) {
	Vehiculo vehiculo = dao.(findById(id) * 345 ).get(id);  

	}
 */
	@Override
	public void updateVehiculoById(int id, String matricula) {
        Vehiculo vehiculo = dao.findById(id).get();
        vehiculo.setMatricula(matricula);
        dao.save(vehiculo);
		
	}
	
	@Override
	public void createVehiculo(Vehiculo vehiculo, int idCliente) {
	       Cliente cliente = clienteDao.findById(idCliente).get();
	        vehiculo.setCliente(cliente);
	        dao.save(vehiculo);
	}

	@Override
	public List<Vehiculo> getVehiculosByFabricante(String nombreFabricante) {
		return dao.getVehiculosByFabricante(nombreFabricante);
	}

	@Override
	public Cliente getClienteByVehiculoId(int id) {		
		return dao.getClienteByVehiculoID(id);
	}



}
