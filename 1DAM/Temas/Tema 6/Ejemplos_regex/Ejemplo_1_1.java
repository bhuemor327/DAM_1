package Ejemplos_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo_1_1 {
    public static void main(String[] args) {

        System.out.println("70588387F: " + validaDNI("70588387F")); // true

        System.out.println("0588387F: " + validaDNI("0588387F")); // false
        System.out.println("F70588387: " + validaDNI("F70588387")); // false
        System.out.println("7058F8387: " + validaDNI("7058F8387")); // false

        System.out.println("1: " + validaDNI("1")); // false
        System.out.println("12345678: " + validaDNI("12345678")); // false
        System.out.println("12345678I: " + validaDNI("12345678I")); // false

    }
    
  //Creamos una función que devolverá un booleano
    
    public static boolean validaDNI(String DNI) {
    	
    	/*/ 1. Compilamos la expresión regular mediante el método .compile()
    		2. Creamos un objeto Matcher utilizando el patrón compilado
    		3. Usamos el método matches() para verificar si el DNI proporcionado coincide con el patrón
    	
    		Obligamos que comience por 8 números del 0-9
    		Obligamos que termine por una serie de letras mayúsculas 
    	/*/
    	
        Pattern pattern = Pattern.compile("^[0-9]{8}[T|R|W|A|G|M|Y|F|P|D|X|B|N|J|Z|S|Q|V|H|L|C|K|E]$");
        Matcher matcher = pattern.matcher(DNI);
        return matcher.matches();
    }

}
