package Ejemplos_File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

//COMBINACIÓN DE PRINTWRITER Y SCANNER
//Escribimos sobre un fichero y posteriormente lo leemos.

public class Ejemplo_08 {
	 public static void main(String args[]) {

	        String frase = "Frase intermedia";
	        //1. Guardamos en un string el nombre del fichero sobre el cual escribiremos
	        String nombreFichero  = "ficheroEnteros.txt";

	        try {
	            //2. Creamos un printWriter donde le pasamos directamente el nombre del fichero.
	        	// 	Este constructor es válido y más corto que el anterior.
	            PrintWriter pwr = new PrintWriter(nombreFichero);

	            //3. Bucle for que dará 1000 vueltas. En cada iteración escribe el valor de i dentro de ese fichero
	            //	 Escribe el entero y concatena un espacio
	            //   Para que no estén en la misma línea se añade un if que inserta un salto cada 100 elementos
	            for (int i = 1; i <= 1000; i++) {
	                pwr.print(i + " ");
	                if (i % 100 == 0) {
	                    pwr.println();
	                    pwr.println(frase);
	                }
	            }
	            pwr.close();
	            
	            
	            //4. Utilizamos un scanner para leer ese mismo fichero.
	            Scanner scn = new Scanner(new FileReader(nombreFichero ));
	            while (scn.hasNext()) {
	                if (scn.hasNextInt())  System.out.println("Valor leído: " + scn.nextInt());
	                else scn.next();
	            }
	            scn.close();

	        } catch (IOException e) {
	            System.out.println("Problemas en el fichero");
	        }
	    }

}
