package Ejemplos_File;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


//DESERIALIZACIÓN
public class Ejemplo_15 {

    public static void main(String[] args) {

        try {

            FileInputStream fis = new FileInputStream("archivo.dat");
            ObjectInputStream in = new ObjectInputStream(fis);

            //1. Hacemos el casting
            System.out.println((Grupo)in.readObject());
            System.out.println("El entero es: "+(int)in.readInt());
            System.out.println((Alumno)in.readObject());

            in.close();

        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }
}