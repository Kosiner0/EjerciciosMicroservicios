package com.curso.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.DOTProducto;
import com.curso.model.Pedido;

@Service
public class PedidosServiceImpl implements PedidosService {

	@Autowired
	RestTemplate template;
	
	private String url = "http://localhost:7000/pedidos";
	private String urlProds = "http://localhost:8000/productos";
	

	@Override
	public List<Pedido> altaPedido(Pedido pedido) {
		template.postForLocation(url + "/alta", pedido);
		DOTProducto producto = template.getForObject(urlProds + "/" + pedido.getCodProd(), DOTProducto.class);
		
		int newStock = producto.getStock() - pedido.getCantidad();
		producto.setStock(newStock);
		
		template.put(urlProds, producto);
		
		return Arrays.asList(template.getForObject(url, Pedido[].class));
	}

	@Override
	public List<Pedido> listaPedidos() {
		return Arrays.asList(template.getForObject(url, Pedido[].class));
	}

}
