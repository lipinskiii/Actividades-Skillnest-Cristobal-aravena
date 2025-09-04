import com.clases.ComputadoraPortatil;
import com.clases.ProductoElectrodomestico;
import com.clases.TiendaElectronica;    
import com.clases.Televisor;

import java.util.ArrayList;

public class Aplicacion {

    public static void main(String args []) {
        TiendaElectronica tienda = new TiendaElectronica();

        Televisor televisor1 = new Televisor("Samsung smart tv", 450.000, 2, "4k", 24.7);
        Televisor televisor2 = new Televisor("Sony tv 4k", 600.000, 0, "8k", 58.4);
        Televisor televisor3 = new Televisor("LG", 120.000, 15, "1080p", 18.4);

        ComputadoraPortatil cPortatil1 = new ComputadoraPortatil("Razer", "16GB ram", 345, "Portatil Razer ultra", 15000.3, 5, "4k", 14.2);
        ComputadoraPortatil cPortatil2 = new ComputadoraPortatil("Nvidia", "8GB ram",478,"Laptop Nvidia",123490.2, 2, "2k", 20.8);
        ComputadoraPortatil cPortatil3 = new ComputadoraPortatil("Asus", "32GB ram", 123, "Asus Rog", 25000.5, 0, "4k", 15.6);
        
        tienda.agregarProducto(televisor1);
        tienda.agregarProducto(televisor2);
        tienda.agregarProducto(televisor3);
        tienda.agregarProducto(cPortatil1);
        tienda.agregarProducto(cPortatil3);
        tienda.agregarProducto(cPortatil2);

        
        System.out.println("Bienvenido a mi tienda electronica");
        tienda.mostrarProductos();

        System.out.println("--- Realizando ventas ---");
        tienda.realizarVenta("Samsung smart tv", 1); // venta normal
        tienda.realizarVenta("LG", 15);          // venta total
        tienda.realizarVenta("Laptop Nvidia", 5);      // venta superior al stock
        tienda.realizarVenta("Asus Rog", 1);        // 0 cantidad disponible
        tienda.realizarVenta("Portatil Vital", 3); // Producto no existente
        

    
    
        System.out.println("Productos disponibles luego de las ventas: ");
        tienda.mostrarProductos();
    }
}
