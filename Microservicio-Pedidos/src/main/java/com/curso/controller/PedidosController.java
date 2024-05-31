package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Pedido;
import com.curso.service.PedidosService;

@RestController
public class PedidosController {

	@Autowired
	PedidosService service;
	
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> listaPedidos(){
		return service.listaPedidos();
	}
	
	@PostMapping(value="pedidos/alta", consumes=MediaType.APPLICATION_JSON_VALUE)
	List<Pedido> altaPedido(@RequestBody Pedido pedido){
		return service.altaPedido(pedido);
	}


}
