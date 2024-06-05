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

/**
 * Controlador que gestiona las operaciones relacionadas con la entidad Cliente.
 */
@RestController
public class ClienteController {

    // Inyección de dependencia del servicio ClienteService.
    @Autowired
    private ClienteService service;

    /**
     * Endpoint que devuelve una lista con todos los clientes.
     * 
     * @return Lista de clientes.
     */
    @GetMapping(value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getListTodosLosClientes() {
        return service.listAllClients();
    }


    @GetMapping(value = "/clientes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Cliente getClienteById(@PathVariable("id") int id) {
        return service.getClienteById(id);
    }

    @GetMapping(value = "/clientes/detalle/{apellido}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Cliente> getClientesByApellido(@PathVariable("apellido") String apellido) {
        return service.getClientesByApellido(apellido);
    }


    @GetMapping(value = "/clientes/{id}/vehiculos", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Vehiculo> getVehiculosByClienteId(@PathVariable("id") int id) {
        return service.listAllVehiclesOwnedByClient(id);
    }


    @DeleteMapping(value = "/clientes/{id}")
    public void deleteClienteById(@PathVariable("id") int id) {
        service.deleteClienteById(id);
    }


    @PostMapping(value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCliente(@RequestBody Cliente cliente) {
        service.createClient(cliente);
    }

    @PostMapping(value = "/clientes/{nombre}/{apellido}")
    public void createCliente(@PathVariable("nombre") String nombre, @PathVariable("apellido") String apellido) {
        Cliente cliente = new Cliente(nombre, apellido);
        service.createClient(cliente);
    }


    @PutMapping(value = "/clientes/{id}/{nombre}/{apellido}")
    public void updateClienteById(@PathVariable("id") int id, @PathVariable("nombre") String nombre,
            @PathVariable("apellido") String apellido) {
        service.updateClienteById(id, nombre, apellido);
    }

}
