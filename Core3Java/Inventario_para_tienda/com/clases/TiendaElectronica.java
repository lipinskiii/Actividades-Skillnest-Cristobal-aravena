package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
        // Lista de productos en el inventario
    private ArrayList<ProductoElectrodomestico> listaDeProductos;

    // Constructor
    public TiendaElectronica() {
        listaDeProductos = new ArrayList<>();
    }

    // Método para agregar un producto al inventario
    public void agregarProducto(ProductoElectrodomestico producto) {
        listaDeProductos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    // Método para mostrar todos los productos disponibles
    public void mostrarProductos() {
        if (listaDeProductos.isEmpty()) {
            System.out.println("No hay productos en el inventario.");
            return;
        }

        for (ProductoElectrodomestico producto : listaDeProductos) {
            System.out.println(producto.mostrarInformacion());
            System.out.println("");
        }
    }

    
    public ProductoElectrodomestico buscarProducto(String nombre) {
        for (ProductoElectrodomestico producto : listaDeProductos) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null; 
    }

    
    public void realizarVenta(String nombre, int cantidad) {
        ProductoElectrodomestico producto = buscarProducto(nombre);

        if (producto == null) {
            System.out.println("Producto no encontrado.");
            return;
        }

        if (producto.getCantidadDisponible() >= cantidad) {
            producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
            System.out.println("Venta realizada: " + cantidad + " unidad(es) de " + nombre);
        } else if (producto.getCantidadDisponible() > 0) {
            System.out.println("No hay suficientes unidades disponibles. Solo se pueden vender " 
                        + producto.getCantidadDisponible() + " unidad(es).");
            producto.setCantidadDisponible(0);
        } else {
            System.out.println("Producto agotado.");
        }
    }
}

