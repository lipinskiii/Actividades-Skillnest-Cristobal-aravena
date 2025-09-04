package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
    public String marca;
    public String memoriaRAM;
    public int numeroDeSerie;

    public ComputadoraPortatil(String marca, String memoriaRAM, int numeroDeSerie, String nombre, Double precio, int cantidadDisponible, String resolucion, Double pulgadas){
        super(nombre, precio, cantidadDisponible);
        this.marca = marca;
        this.memoriaRAM = memoriaRAM;
        this.numeroDeSerie = numeroDeSerie;
    }
    
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public String getMemoriaRAM(){
        return memoriaRAM;
    }
    public void setMemoriaRAM(String memoriaRAM){
        this.memoriaRAM = memoriaRAM;
    }
    public int getNumeroDeSerie(){
        return numeroDeSerie;
    }
    public void setNumeroDeSerie(int numeroDeSerie){
        this.numeroDeSerie = numeroDeSerie;
    }

    @Override
    public String mostrarInformacion() {
            return super.mostrarInformacion() +
            "Marca: " + marca + "MemoriaRAM: " + memoriaRAM + "Numero de serie: " + numeroDeSerie;
    }

}
