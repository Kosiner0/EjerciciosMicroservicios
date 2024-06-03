package com.curso.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.dao.PedidosDao;
import com.curso.model.Pedido;
@Service
public class PedidosServiceImpl implements PedidosService {
	@Autowired
	PedidosDao pedidosDao;
	@Autowired
	RestTemplate restTemplate;
	
	private final static String url = "http://localhost:8080/";
	@Override
	public List<Pedido> pedidos() {
		return pedidosDao.findAll();
	}

	@Override
	public void altaPedido(Pedido pedido) {
		pedido.setFechaPedido(LocalDateTime.now());
		pedido.setTotal(pedido.getUnidades()*obtenerPrecio(pedido.getCodigoProducto()));
        pedidosDao.save(pedido);
        actualizarStock(pedido.getCodigoProducto(),pedido.getUnidades());
	}
	
	private double obtenerPrecio(int codigoProducto) {
		return  Double.parseDouble(restTemplate.getForObject(url+"precio/{codigo}", String.class, codigoProducto));
	}
	 
	private void actualizarStock(int codigoProducto, int unidades) {
		
		// void put(String url, Object request, Object...uriVar)
		restTemplate.put(url+"productos/{codigo}/{unidades}", null, codigoProducto, unidades);
	}

}
