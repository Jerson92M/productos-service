package com.facturacion.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.facturacion.model.Producto;
import com.facturacion.service.IProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoResource {

	@Autowired
	IProductoService service;
	
	@GetMapping
	public List<Producto> getAll(@RequestParam( required = false) String codigo){
		
		List<Producto> clientes =  service.getAll(codigo);
		
		return clientes;
	}
	
	@PostMapping
	public ResponseEntity<?> add(@RequestBody Producto producto){
	
		return service.add(producto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody Producto producto){
		
		return service.update(id, producto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		
		return service.delete(id);
	}
	
}
