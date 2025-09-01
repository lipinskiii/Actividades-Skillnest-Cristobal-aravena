public class Algoritmos {

    public static boolean esPar (int numero){
        return numero % 2 == 0;
    }
    
    public static boolean esPrimo (int numero){
        if (numero <= 1){
            return false;
        }
        if (numero == 2){
            return true;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
    public static String stringEnReversa (String texto){
        StringBuilder reverso = new StringBuilder();
        
        for (int i = texto.length() - 1; i >= 0; i--){
            reverso.append(texto.charAt(i));

        }
        return reverso.toString();
    }
    public static Boolean esPalindromo (String texto){
        int longitud = texto.length();
    
        for (int i = 0; i < longitud / 2; i++){
            if (texto.charAt(i) != texto.charAt(longitud - 1 - i)) {
                return false;
            }
    }
    return true;
}
    public static String secuenciaFizzBuzz (int numero){
        for (int i = 1; i <= numero; i++){
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);


        }
        return "";
    }
}
        

