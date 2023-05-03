package com.upc.demoproductos.negocio;

import com.upc.demoproductos.entidades.Producto;

import java.util.List;

public interface IProductoNegocio {
    public Producto registrar(Producto producto);
    public Producto buscar(Long codigo) throws Exception;
    public List<Producto> listado();
    public Producto actualizar(Producto producto) throws Exception;
    public double calcularIGV(Producto producto);
    public double calcularDescuento(Producto producto);
    public double calcularPrecioVenta(Long codigo) throws Exception;
    public double calcularPrecioVenta(Producto producto);
    public List<Producto>listadoProductosPorDescripcion(String prefijo);
    public List<Producto> listadoTotal();
    public Producto eliminar(Long codigo) throws Exception;
}
