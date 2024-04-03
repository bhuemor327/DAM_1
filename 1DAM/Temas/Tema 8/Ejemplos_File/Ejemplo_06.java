package Ejemplos_File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


//EJEMPLO PRINTWRITER

public class Ejemplo_06 {

	 public static void main(String args[]) {
		 	
		 // 1. Creamos un string llamado fichero con el nombre del fichero
	        String fichero = "fichero.txt";

	        try {
	           
	        	//2. Creamos la instancia PrintWriter que recibe como parámetro una nueva instancia de la clase FileWriter pasándol a su vez el string fichero
	        	//   Al no haber utilizado append, si el archivo existe lo truncará y si no existe lo creará
	            PrintWriter pw = new PrintWriter(new FileWriter(fichero, true));
	            
	            
	            //3. Utilizamos el método print para escribir sin salto de línea, con salyo de linea y un double
	            pw.print("Esto es un texto sin salto de línea");
	            pw.println("NUEVA PALABRA");
	            pw.println("Esto es un texto con salto de línea");
	            pw.println(4.5455);

	            //4. Cerramos el PrintWriter
	            pw.close();

	        } catch (FileNotFoundException e) {
	            System.out.println("Fichero no encontrado");
	        } catch (IOException e) {
	            System.out.println("Problemas al escribir en el fichero");
	        }
	    }
	
}
