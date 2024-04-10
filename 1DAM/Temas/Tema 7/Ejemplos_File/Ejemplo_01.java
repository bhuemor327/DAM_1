package Ejemplos_File;

import java.io.File;

public class Ejemplo_01 {

    public static void main(String[] args) {

        //Creamos una instancia de la clase File y le pasamos un fichero
        //File fichero = new File("ejemplo1.txt");
        File fichero = new File("../Ejemplo.txt");
        
        if (fichero.exists())
            System.out.println("El fichero existe");
        else
            System.out.println("El fichero no existe");
        
        //Invocamos los métodos vistos a partir de la instancia fichero
        System.out.println("Nombre: " + fichero.getName());
        System.out.println("Longitud: " + fichero.length());
        System.out.println("Ruta absoluta: " + fichero.getAbsolutePath()+"\n\n");

        //Realizamos lo mismo pero con una carpeta (ponemos la ruta de la carpeta)
        File carpeta = new File("Carpeta1");
        if (carpeta.exists())
            System.out.println("La carpeta existe");
        else
            System.out.println("La carpeta no existe");
        System.out.println("Nombre: " + carpeta.getName());
        System.out.println("Longitud: " + carpeta.length());
        System.out.println("Ruta absoluta: " + carpeta.getAbsolutePath());
    }
}