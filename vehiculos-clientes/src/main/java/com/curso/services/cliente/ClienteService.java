package com.curso.services.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ClienteDao;
import com.curso.model.Cliente;
import com.curso.model.Vehiculo;
@Service
public class ClienteService implements IClienteService {
    @Autowired
    private ClienteDao dao;
	@Override
	public List<Cliente> listAllClients() {
		return dao.findAll();
	}

	@Override
	public List<Vehiculo> listAllVehiclesOwnedByClient(int id) {
		return dao.getVehiculosByClienteId(id);
	}

	@Override
	public Cliente getClienteById(int id) {
		return dao.findById(id).get();
	}

	@Override
	public void deleteClienteById(int id) {
		dao.deleteById(id);

	}

	@Override
	public void updateClienteById(int id, String nombre, String apellido) {
	      Cliente cliente = dao.findById(id).get();
	        cliente.setNombre(nombre);
	        cliente.setApellido(apellido);
	        dao.save(cliente);
	    }

	@Override
	public void createClient(Cliente cliente) {
		dao.save(cliente);

	}

	@Override
	public List<Cliente> getClientesByApellido(String apellido) {
		return dao.getClientesByApellido(apellido);
	}

}
