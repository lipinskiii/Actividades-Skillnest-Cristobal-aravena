import clases.CuentaBancaria;
import clases.Persona;

public class Aplicacion {
    public static void main(String args []){
        Persona persona1 = new Persona("Juan", 25);
        Persona persona2 = new Persona("Alberto", 30);        
        Persona persona3 = new Persona("Amanda", 48);

        CuentaBancaria cuenta1 = new CuentaBancaria(persona1, 2000);
        CuentaBancaria cuenta2 = new CuentaBancaria(persona2, 4000);
        CuentaBancaria cuenta3 = new CuentaBancaria(persona3, 6700);

        cuenta1.depositar(450);
        cuenta2.retirar(40000);
        cuenta2.depositar(400);
        cuenta3.retirar(100);

        System.out.println("Saldos actuales:");
        System.out.println("Cuenta 1: $" + cuenta1.getSaldo());
        System.out.println("Cuenta 2: $" + cuenta2.getSaldo());
        System.out.println("Cuenta 3: $" + cuenta3.getSaldo());

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();

    }
    
}
