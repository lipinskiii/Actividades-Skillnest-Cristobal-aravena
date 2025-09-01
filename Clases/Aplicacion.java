public class Aplicacion {
    public static void main(String[] args){

        // Prueba esPar
        System.out.println("esPar(4): " + Algoritmos.esPar(4)); // true
        System.out.println("esPar(7): " + Algoritmos.esPar(7)); // false

        // Prueba esPrimo
        System.out.println("esPrimo(2): " + Algoritmos.esPrimo(2)); // true
        System.out.println("esPrimo(17): " + Algoritmos.esPrimo(17)); // true
        System.out.println("esPrimo(18): " + Algoritmos.esPrimo(18)); // false

        // Prueba stringEnReversa
        String texto = "Prueba texto en reversa";
        System.out.println("stringEnReversa(\"" + texto + "\"): " + Algoritmos.stringEnReversa(texto));

        // Prueba esPalindromo
        String palindromo1 = "anitalavalatina";
        String palindromo2 = "Hola";
        System.out.println( palindromo1 + "\"): " + Algoritmos.esPalindromo(palindromo1)); // true
        System.out.println( palindromo2 + "\"): " + Algoritmos.esPalindromo(palindromo2)); // false

        // Prueba secuenciaFizzBuzz
        int numero = 15;
        System.out.println("secuenciaFizzBuzz(" + numero + "):");
        System.out.println(Algoritmos.secuenciaFizzBuzz(numero));
    }
}


