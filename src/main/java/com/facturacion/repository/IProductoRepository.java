package com.facturacion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.facturacion.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer>{

	List<Producto> findAllByCodigoContains(String producto);
}
