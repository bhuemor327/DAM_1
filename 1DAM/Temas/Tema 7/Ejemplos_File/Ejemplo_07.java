package Ejemplos_File;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Uso de Scanner

public class Ejemplo_07 {
	
	 public static void main(String args[]) {
		 
		 	//1. Creamos una instancia de la clase File que hará referencia a nuestro fichero
	        File archivo = new File("fichero.txt");
	        
	        //2. Dentro del try catch realizamos todas las operaciones 
	        //   Se irá al catch siempre y cuando no se encuentre el fichero
	        //   Como solo leemos, si el archivo no existe no hará nada, se irá al catch.
	        try {
	        	// 3. Creamos el scanner pasandole una instancia de la clase File
	               Scanner scn = new Scanner(archivo);
	   
	            /*/ 4. A través de un while leemos información del archivo. Utilizamos como condición el método hasNextLine()
	             		- Este método devuelve true si aún quedan líneas por leer.
	             		- Si queda información por leer creamos el string linea y le asignamos el método nextLine() quedandonos así con una sola línea
	             		- Imprimimmos 
	              /*/
	               while (scn.hasNextLine()) {
	                   String linea = scn.nextLine();
	                   System.out.println(linea);
	               }
	               scn.close();
	   
	           } catch (FileNotFoundException e) {
	               System.err.println("No se pudo encontrar el archivo");
	           }
	   }

}
