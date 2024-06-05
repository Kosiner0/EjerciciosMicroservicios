package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Cliente;
import com.curso.model.Vehiculo;
import com.curso.services.cliente.ClienteService;
import com.curso.services.vehiculo.VehiculoService;

@RestController
public class VehiculoController {

	@Autowired
	private VehiculoService service;
    @Autowired
    private ClienteService clienteService;
	
	/**
	 * EndPoint que devuelve una lista con todos los vehículos
	 * @return   Lista de vehiculos
	 */
	
    @GetMapping(value = "/vehiculo", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getListTodosLosVehiculos() {
        return service.listAllVehicles();
    }

    /**
     * Endpoint que devuelve un vehículo específico según su ID.
     * 
     * @param id ID del vehículo a recuperar.
     * @return Vehículo buscado.
     */
    @GetMapping(value = "/vehiculo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoById(@PathVariable int id) {
        return service.getVehiculoById(id);
    }


    @GetMapping(value = "/vehiculo/propietario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteByVehiculoId(@PathVariable int id) {
        return service.getClienteByVehiculoId(id);
    }


    @GetMapping(value = "/vehiculo/detalle/matricula/{matricula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Vehiculo getVehiculoByMatricula(@PathVariable String matricula) {
        return service.getVehiculoByMatricula(matricula);
    }

    @GetMapping(value = "/vehiculo/detalle/{nombreFabricante}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByFabricante(@PathVariable String nombreFabricante) {
        return service.getVehiculosByFabricante(nombreFabricante);
    }

    @DeleteMapping(value = "/vehiculo/{id}")
    public void deleteVehiculoById(@PathVariable int id) {
        service.deleteVehiculoById(id);
    }

    @PutMapping(value = "/vehiculo/{id}/{matricula}")
    public void updateVehiculoById(@PathVariable int id, @PathVariable String matricula) {
        service.updateVehiculoById(id, matricula);
    }


    @PostMapping(value = "/vehiculo/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVehiculo(@RequestBody Vehiculo vehiculo, @PathVariable int id) {
        service.createVehiculo(vehiculo, id);
    }

    @PostMapping(value = "/vehiculo/{matricula}/{fabricante}/{modelo}/{clienteId}")
    public void createVehiculoByURLParams(@PathVariable("matricula") String matricula,
            @PathVariable("fabricante") String fabricante, @PathVariable("modelo") String modelo,
            @PathVariable("clienteId") int clienteId) {
        Cliente clienteRecuperado = clienteService.getClienteById(clienteId);
        Vehiculo vehiculo = new Vehiculo(matricula, fabricante, modelo, clienteRecuperado);
        service.createVehiculo(vehiculo, clienteRecuperado.getId());
    }

}

