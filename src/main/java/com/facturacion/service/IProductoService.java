package com.facturacion.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.facturacion.model.Producto;

public interface IProductoService {

	public List<Producto> getAll(String codigo);

	public ResponseEntity<?> add(Producto producto);

	public ResponseEntity<?> update(Integer id, Producto producto);

	public ResponseEntity<?> delete(Integer id);
}
