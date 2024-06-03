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
	PedidosService pedidosService;
	
	@GetMapping(value="pedidos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Pedido> pedidos(){
		return pedidosService.pedidos();
	}
	@PostMapping(value="pedidos", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void altaPedido(@RequestBody Pedido pedido) {
		pedidosService.altaPedido(pedido);
	}
}
