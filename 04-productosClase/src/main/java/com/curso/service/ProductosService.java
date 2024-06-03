package com.curso.service;

import java.util.List;

import com.curso.model.Producto;

public interface ProductosService {
	List<Producto> productos();
	double precioProducto(int codigoProducto);
	void actualizarStock(int codigoProducto, int unidades);
}
