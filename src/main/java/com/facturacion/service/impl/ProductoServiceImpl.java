package com.facturacion.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.facturacion.model.Producto;
import com.facturacion.repository.IProductoRepository;
import com.facturacion.service.IProductoService;
import com.facturacion.utils.Response;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	IProductoRepository repository;
	
	@Override
	public List<Producto> getAll(String codigo) {
		
		List<Producto> productos;
		
		if (codigo == null || codigo.isEmpty()) {
			productos = repository.findAll();
		} else {	
			productos = repository.findAllByCodigoContains(codigo);
		}
		
		return productos;
	}

	@Override
	public ResponseEntity<?> add(Producto producto) {
		
		String message = "OK";
		HttpStatus status = HttpStatus.OK;
		
		repository.save(producto);		

		return new ResponseEntity<>(new Response(message), status);
		
	}

	@Override
	public ResponseEntity<?> update(Integer id, Producto producto) {
		
		String message = "OK";
		HttpStatus status = HttpStatus.CREATED;
		
		repository.getOne(id);
		
		producto.setId(id);
		repository.save(producto);
		
		return new ResponseEntity<>(new Response(message), status);
		
	}

	@Override
	public ResponseEntity<?> delete(Integer id) {
		
		String message = "OK";
		HttpStatus status = HttpStatus.NO_CONTENT;
		
		repository.deleteById(id);
		
		return new ResponseEntity<>(new Response(message), status);
		
	}


}
