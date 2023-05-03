package com.upc.demoproductos.rest;

import com.upc.demoproductos.entidades.Producto;
import com.upc.demoproductos.negocio.IProductoNegocio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ProductoRest {
    @Autowired
    private IProductoNegocio productoNegocio;
    Logger logger = LoggerFactory.getLogger(ProductoRest.class);
    @GetMapping("/productos")
    public List<Producto> lista(){
        return productoNegocio.listado();
    }

    @GetMapping("/productosTotal")
    public List<Producto> listadoTotal(){
        return productoNegocio.listadoTotal();
    }
    @GetMapping("/productosDescripcion/{descripcion}")
    public List<Producto> listadoDescripcion(@PathVariable(value = "descripcion") String descripcion){
        return productoNegocio.listadoProductosPorDescripcion(descripcion.toUpperCase());
    }
    @PostMapping("/producto")
    public Producto registrar(@RequestBody Producto producto){
        return productoNegocio.registrar(producto);
    }
    @GetMapping("/producto/{codigo}")
    public Producto buscar(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.buscar(codigo);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }

    @PutMapping("/producto/{codigo}")
    public Producto actualizar(@RequestBody Producto producto){
        try {
            return productoNegocio.actualizar(producto);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }

    @DeleteMapping("/producto/{codigo}")
    public Producto eliminar(@PathVariable(value = "codigo") Long codigo){
        try {
            return productoNegocio.eliminar(codigo);
        } catch (Exception e) {
            logger.error("Error critico en la aplicación: " + e );
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontró el código",e);
        }
    }
}
