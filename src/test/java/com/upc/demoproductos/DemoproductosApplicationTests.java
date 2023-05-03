package com.upc.demoproductos;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import com.upc.demoproductos.negocio.ProductoNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoproductosApplicationTests {
	@Autowired
	private IProductoNegocio productoNegocio;
	@Test
	void contextLoads() {
	}
	@Test
	void testRegistro(){
		Producto producto = new Producto();
		producto.setDescripcion("Pepsi");
		producto.setPrecio(3);
		producto.setStock(30);
		productoNegocio.registrar(producto);
	}
	@Test
	void testBuscar(){
		try {
			productoNegocio.buscar(3L);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testListado(){
		List<Producto> lista;
		lista = productoNegocio.listado();
		for(Producto p : lista){
			System.out.println(p.getCodigo() + " - " + p.getDescripcion() + " - " + p.getStock());
		}
	}

	@Test
	void testPrecioVenta(){
		try {
			double venta;
			venta = productoNegocio.calcularPrecioVenta(2L);
			System.out.println("El precio de venta es: "+venta);
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	@Test
	void testActualizar(){
		Producto producto = new Producto();
		producto.setCodigo(1L);
		producto.setDescripcion("Pepsi Max");
		producto.setPrecio(3);
		producto.setStock(50);
		try {
			productoNegocio.actualizar(producto);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	void testListadoPorDescripcion(){
		List<Producto> listado;
		listado = productoNegocio.listadoProductosPorDescripcion("Pep");
		for(Producto producto:listado){
			System.out.println(producto.getCodigo()+ " - "+producto.getDescripcion());
		}
	}

	@Test
	void testListadoTotal(){
		List<Producto> listado;
		listado = productoNegocio.listadoTotal();
		for(Producto producto:listado){
			System.out.println(producto.getCodigo()+ " - "+producto.getDescripcion()+" - "+producto.getTotal());
		}
	}
}
