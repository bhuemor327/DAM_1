package Ejemplos_regex;

//Validación del formato de un nombre de persona

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo_2 {

	
	public static void main(String[] args) {

      System.out.println("Manuel: " + validarNombre("Manuel")); //True
      System.out.println("Fernando: " + validarNombre("Fernando")); //True
      System.out.println("Manuel Fernando: " + validarNombre("Manuel Fernando")); //True
      System.out.println("manuel: " + validarNombre("manuel")); //False
      System.out.println("12343: " + validarNombre("12343")); //False
      System.out.println("Manuel  Fernando: " + validarNombre("Manuel  Fernando")); //False (2 espacios)
      System.out.println("M: " + validarNombre("M")); //False
      System.out.println("Ma: " + validarNombre("Ma")); //True

  }
	
//Creamos una función que devolverá un booleano
  
  public static boolean validarNombre(String nombre) {
  	/*/ Características del nombre
  	 1. Empezar con una y solo una letra mayúscula [A-Z]{1}
  	 2. El resto deben ser letras minúsculas (mínimo una) [a-z]+
  	 3. Pueden tener un espacio opcional para cuando se trate de un nombre compuesto [ ]?
  	 	La interrogación indica que es opcional (0 o 1 veces)
  	 4. Todo lo anterior se repite una o dos veces (para nombres simples o compuestos
  	 */

      Pattern pattern = Pattern.compile("^([A-Z]{1}[a-z]+[ ]?){1,2}$");
      Matcher matcher = pattern.matcher(nombre);
      return matcher.matches();
  }	
}
