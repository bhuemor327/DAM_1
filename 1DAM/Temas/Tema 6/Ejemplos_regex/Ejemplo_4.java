package Ejemplos_regex;

//Validar Matriculas de coche

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo_4 {
  public static void main(String[] args) {

      System.out.println(validarMatricula("1234ABC"));
      System.out.println(validarMatricula("1234abc"));
      System.out.println(validarMatricula("12abc"));
      System.out.println(validarMatricula("1234AB"));
      System.out.println(validarMatricula("1A"));
      System.out.println(validarMatricula("12345ABC"));
      System.out.println(validarMatricula("1234a3b"));


  }
  
//Creamos una función que devolverá un booleano
  
  public static boolean validarMatricula(String matricula) {
  	
  	/*/ La matricula debe tener la siguiente estructura
  	 1. Empezar por 4 números
  	 2. Seguido de 3 letras
  	/*/
  	
      Pattern pattern = Pattern.compile("^[0-9]{4}[A-Z]{3}$");
      Matcher matcher = pattern.matcher(matricula);
      return matcher.matches();
  }

}

