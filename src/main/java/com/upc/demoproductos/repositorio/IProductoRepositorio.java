package com.upc.demoproductos.repositorio;

import com.upc.demoproductos.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProductoRepositorio extends JpaRepository<Producto,Long> {
    public List<Producto> findByDescripcionStartingWith(String prefix);
    @Query("select p from Producto p where upper(p.descripcion) like %:prefijo%")
    public List<Producto> obtenerReportePorDescripcion(@Param("prefijo") String prefijo);
    public List<Producto> findByPrecioIsLessThan(double precio);
}
