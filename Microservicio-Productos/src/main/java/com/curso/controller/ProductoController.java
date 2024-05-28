package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Producto;
import com.curso.service.ProductosService;

@RestController
public class ProductoController {

	@Autowired
	ProductosService service;
	
	@GetMapping(value="productos")
	List<Producto> listaProductos(){
		return service.listaProductos();
	}
	
	@GetMapping(value="productos/{codigo}")
	Producto productoPorCodigo(@PathVariable int codigo){
		return service.productoPorCodigo(codigo);
	}
	
	@PutMapping(value="productos/actualizar/{codigo}/{unidades}")
    public List<Producto> actualizarStockProducto(@PathVariable("codigo") int codigo, @PathVariable("unidades") int unidades) {
        return service.actualizarStockProducto(codigo, unidades);
    }
	
	@GetMapping(value="productos/getPrecio/{codigo}")
	double getPrecioProducto(@PathVariable int codigo){
		return service.getPrecioProducto(codigo);
	}
	
}
