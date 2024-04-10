package Ejemplos_File;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio_Buffer {
    public static void main(String[] args) {
    Ejercicio_Buffer.creaFichero("Prueba", 5);
    }
    public static void creaFichero(String nombreFichero, int numLineas){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(nombreFichero, true));
            for (int i = 0; i <= numLineas; i++) {
                bw.newLine();
                bw.write("Esta es la linea " + i);
                //bw.flush();
            }
            bw.close();
        }catch (IOException e){
            System.out.println("Excepcion");
        }
    }
}
