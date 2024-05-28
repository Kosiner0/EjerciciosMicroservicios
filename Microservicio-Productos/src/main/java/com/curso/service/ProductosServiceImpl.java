package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.dao.ProductosDao;
import com.curso.model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	ProductosDao dao;
	
	
	@Override
	public List<Producto> listaProductos() {
		return dao.findAll();
	}
	
	@Override
	public Producto productoPorCodigo(int codigo) {
		return dao.findById(codigo).orElse(null);
	}

	@Override
	public List<Producto> actualizarStockProducto(int codigo, int unidades) {
		Producto producto = dao.findById(codigo).orElse(null);
		
		if (producto != null) {
            int stockActual = producto.getStock();
            producto.setStock(stockActual - unidades);
            dao.save(producto);
        }
		
		return dao.findAll();
	}

	@Override
	public double getPrecioProducto(int codigo) {
		Producto producto = dao.findById(codigo).orElse(null);
		return producto.getPrecio();
	}

	

}
