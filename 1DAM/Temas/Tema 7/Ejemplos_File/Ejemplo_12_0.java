package Ejemplos_File;


import java.io.FileInputStream;
import java.io.IOException;

public class Ejemplo_12_0 {

    public static void main(String[] args) {

        String fileName = "ejemplo.dat";
        // Leer datos desde el archivo binario
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int num;
            System.out.println("Datos leídos desde el archivo binario:");
            while ((num = fis.read()) != -1)
                System.out.print(num + " ");
            fis.close();
        } catch (IOException e) {
            System.err.println("Error al leer");
        }
    }

}