package com.curso.service;

import java.util.List;

import com.curso.model.Producto;

public interface ProductosService {

	List<Producto> listaProductos();
	Producto productoPorCodigo(int codigo);
	List<Producto> actualizarStockProducto(int codigo, int unidades);
	double getPrecioProducto(int codigo);
}
