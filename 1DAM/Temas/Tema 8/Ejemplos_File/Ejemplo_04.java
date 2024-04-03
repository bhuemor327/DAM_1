package Ejemplos_File;
import java.io.FileWriter;
import java.io.IOException;

//EJEMPLO DE CLASE FILEWRITER PARA ESCRIBIR DATOS EN UN FICHERO
//Este archivo se genera en la carpeta desde la que ejecutamos el programa
public class Ejemplo_04 {

	public static void main(String[] args) {

       //1. Creamos dos variables de tipo String (Texto y fichero) ya que queremos añadir dicho texto en el fichero indicado
		String texto = "Este es un ejemplo de uso de FileWriter en JAVA --- \n";
        String fichero = "fichero_FileWriter.txt";

        try {
            // 2. Creamos un objeto FileWriter con el constructor visto anteriormente que recibe solo un string . 
        	//	  el nombre del fichero y un booleano que indica que añadimos el texto al final del fichero
            FileWriter fileWriter = new FileWriter(fichero, true);

            // 3. A partir de esa instancia invocamos al método wirte pasandole el String que queremos añadir en el archivo
            //   Al no utilizar el constructor con el append, si el fichero existe lo machaca, y si no existe lo creará
            fileWriter.write(texto);

            // 4. Cerramos el FileWriter
            fileWriter.close();

            System.out.println("Se ha escrito en el fichero correctamente");

        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el fichero");
            e.printStackTrace();
        }
	
	
}
}