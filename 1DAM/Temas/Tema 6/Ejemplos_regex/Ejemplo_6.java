package Ejemplos_regex;

//Validar mail

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Ejemplo_6 {
	
 public static void main(String[] args) {
     String[] correos = {
         "nombre.apellido@gmail.com",
         "juan.perez123@yahoo.es",
         "maria_gonzalez123@hotmail.com",
         "invalido@dominio", // dirección incompleta sin dominio de nivel superior
         "nombre.apellido@gmail.com", // dirección inválida (no sigue el formato nombre.apellido@xxx.ss)
         "nombre.apellido@xx.s" // dirección inválida (dominio de nivel superior con menos de 2 caracteres)
     };
     
     /*/ 1. El nombre de usuario debe estar compuesto únicamente por letras minúsculas y/o números y ser del tipo
				nombre.apellido
			2. Debe estar seguido de un @
			3. El formato del dominio debe contener letras en minúsucla y al menos un punto seguido de 3 letras minúsculas como máximo
		/*/
     Pattern patronCorreo = Pattern.compile("^[a-z0-9]+\\.[a-z0-9]+@[a-z0-9]+\\.[a-z]{2,3}$");

     for (String correo : correos) {
         Matcher matcher = patronCorreo.matcher(correo);
         if (matcher.matches()) {
             System.out.println(correo + " es una dirección de correo electrónico válida.");
         } else {
             System.out.println(correo + " no es una dirección de correo electrónico válida.");
         }
     }
 }
}
