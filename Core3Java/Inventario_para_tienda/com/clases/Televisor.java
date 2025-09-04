package com.clases;

public class Televisor extends ProductoElectrodomestico {
        public String resolucion = "";
        public Double pulgadas = 0.0;
    
    public Televisor(String nombre, Double precio, int cantidadDisponible, String resolucion, Double pulgadas){
        super(nombre, precio, cantidadDisponible);
        this.resolucion = resolucion;
        this.pulgadas = pulgadas;
    }
    
    // Getters y Setters
    public Double getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(Double pulgadas) {
        this.pulgadas = pulgadas;
    }

    public String getResolucion() {
        return resolucion;
    }

    public void setResolucion(String resolucion) {
        this.resolucion = resolucion;
    }

    @Override 
    public String mostrarInformacion() {
            return super.mostrarInformacion() +
                ", Tamaño de pantalla: " + pulgadas + " pulgadas" +
                ", Resolución: " + resolucion;
    }
}
    

