package com.upc.demoproductos.entidades;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "TBL_PRODUCTO")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;
    private double precio;
    private int stock;

    private transient double total;
    public Producto(){

    }
    public Producto(Long codigo, String descripcion, double precio, int stock){
        this.setCodigo(codigo);
        this.setDescripcion(descripcion);
        this.setPrecio(precio);
        this.setStock(stock);
    }
}
