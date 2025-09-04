package clases;

import java.util.ArrayList;
import java.util.Random;


    public class CuentaBancaria {
        public double saldo;
        
        public int numeroDeCuenta;
        private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();
        private Persona titular;

    public CuentaBancaria(Persona titular, double saldoInicial) {
        this.titular = titular;
        this.saldo = saldoInicial;
        this.numeroDeCuenta = generadorNumeroCuenta();
        listaDeCuentasBancarias.add(this);
    }

    private int generadorNumeroCuenta() {
        Random random = new Random();
        return 100000 + random.nextInt(899999);
    }

    public Persona getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroDeCuenta;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } 
    }

    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo: $" + saldo);
        } else if (monto > saldo) {
            System.out.println("Fondos insuficientes.");
        }
    }

    public void despliegaInformacion() {
        System.out.println("Titular: " + titular.getNombre());
        System.out.println("Número de cuenta: " + numeroDeCuenta);
        System.out.println("Saldo: $" + saldo);
    }

    public static void imprimeInformacionDeTodasLasCuentas() {
        System.out.println(" Lista de todas las cuentas bancarias:");
        for (CuentaBancaria cuenta : listaDeCuentasBancarias) {
            cuenta.despliegaInformacion();
            System.out.println("-------------------");
        }
    }

    
}