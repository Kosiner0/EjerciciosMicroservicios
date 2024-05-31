package com.curso.service;

import java.util.List;

import com.curso.model.Pedido;

public interface PedidosService {

	List<Pedido> altaPedido(Pedido pedido);
	List<Pedido> listaPedidos();
}
