package Ejemplos_regex;

//Validar Fechas

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejemplo_5 {
  public static void main(String[] args) {
  	
  	String[] fechas = {
  			"02/09/2010", "02/9/2010","02/09/010", "29/9/2010", "00/7/1910"
          };

  	for( String fecha: fechas) {
  			if(validarFecha(fecha) == true) {
  				System.out.println("La fecha "+  fecha + " es correcta") ;   		
  			} else 
		    		System.out.println("La fecha " + fecha + " es incorrecta") ;
  	}
  }

//Creamos una función que devolverá un booleano
  
  public static boolean validarFecha(String fecha) {
  	
  	/*/ Se tiene en cuenta lo siguiente:
  	  	1. Para indicar que / debe ser encontrado literamente y no como un delimitador, es necesario indicarle por delante \\
  	 	2. Para el día, como puede establecerse 09 ó 9, debemos indicar el 0 como opcional: 0?[1-9]
  	 	   Además, para los días desde el 10 al 29, indicamos [12][0-9] que es combinar el 1 con cualquier número del 0 al 9 
  	 		o bien el 2 con cualquier número del 0 al 9.
  	 	   Finalmente, como solo tenemos 30 ó 31 días, estas excepciones se añaden después del |
  	/*/
  	
      Pattern pattern = Pattern.compile("^(0?[1-9]|[12][0-9]|3[01])[\\/](0?[1-9]|1[012])[\\/](\\d{4})$");
      Matcher matcher = pattern.matcher(fecha);
      return matcher.matches();
  }

}

