package Ejemplos_File;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Ejemplo_10 {

    public static void main(String[] args) {

        String nombreFichero = "archivo.txt";
     

        numeroPalabras(nombreFichero);
    }

    // Crea un método que recibe un archivo y devuelva la cantidad de palabras 
    // de dicho archivo. Utiliza un buffer para realizar la lectura de forma más eficiente

    public static void numeroPalabras(String nombreFichero) {
        try {
            
        	int contarPalabras =0;
            BufferedReader br = new BufferedReader(new FileReader (nombreFichero));
            String linea ;
            
            //Leemeos linea a linea.
            // 1. Almacenamos en linea la primera linea del archivo con readline() que devuelve un string
            // 2. Si no hubiera nada en el archivo devolvería un null y no entraría en el bucle
            // 3. Dentro del bucle contamos las palabras de cada línea y las acumulamos
            //		Con el método split, pasandole "\\s+" lo que hacemos es que a partir del string Linea 
            //      se crea un array de strings con cada una de las palabras de esa línea
            // 4. A contarPalabras le añadimos el tamaño de ese array
            while((linea = br.readLine()) != null) {
            	String [] palabrasLinea = linea.split("\\s+");
            	contarPalabras += palabrasLinea.length;
            }
           
            
            // Al cerrar el br se cierra el filereader
           br.close();

            System.out.println("El archivo " + nombreFichero + " contiene " + contarPalabras + " palabras");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
