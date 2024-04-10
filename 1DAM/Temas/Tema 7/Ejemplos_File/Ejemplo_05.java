package Ejemplos_File;
import java.io.FileReader;
import java.io.IOException;

//EJEMPLO DE CLASE FILEREADER PARA LEER DATOS DE UN FICHERO

public class Ejemplo_05 {
	public static void main(String[] args) {
		
		// 1. Creamos la variable fichero con el nombre del mismo
        String fichero = "fichero_FileWriter.txt";

        try {
            // 2. creamos un objeto FileReader pasandole ese fichero
            FileReader fileReader = new FileReader(fichero);

            // 3. Para leer y mostrar el contenido del archivo lo haremos a través de una variable de tipo entero
            //    ya que el método read() nos devolverá un entero con el valor UNICODE de ese caracter
            int caracter;
            
            //A través de un bucle while utilizamos la condición de que sea distinto de -1 ya que el método read devuelve -1
            // cuando llega al final. Por lo tanto, iremos leyendo todos los caracteres mientras no se encuentre ese final del fichero.
            System.out.println("Contenido del archivo " + fichero + ":");
            while ((caracter = fileReader.read()) != -1) {
                System.out.print((char)caracter);
            }

            // cerramos el FileReader
            fileReader.close();

        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo");            
        }

    }
}
