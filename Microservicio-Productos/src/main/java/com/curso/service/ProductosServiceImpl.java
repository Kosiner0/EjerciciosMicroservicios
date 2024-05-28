package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.Producto;

@Service
public class ProductosServiceImpl implements ProductosService {

	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost:8000/productos";
	
	
	@Override
	public List<Producto> listaProductos() {
		return Arrays.asList(template.getForObject(url, Producto[].class));
	}
	
	@Override
	public Producto productoPorCodigo(int codigo) {
		String urlProducto = url + "/" + codigo;
		return template.getForEntity(urlProducto, Producto.class).getBody();
	}

	@Override
	public List<Producto> actualizarStockProducto(int codigo, int unidades) {
		String urlProducto = url + "/" + codigo;
		Producto producto = template.getForEntity(urlProducto, Producto.class).getBody();
		
		if (producto != null) {
            int stockActual = producto.getStock();
            producto.setStock(stockActual - unidades);

            template.put(urlProducto, producto);
        }
		
		return Arrays.asList(template.getForObject(url, Producto[].class));
	}

	@Override
	public double getPrecioProducto(int codigo) {
		String urlPrecio = url + "/" + codigo ;
		Producto producto = template.getForEntity(urlPrecio, Producto.class).getBody();
		
		return producto.getPrecio();
	}

	

}
