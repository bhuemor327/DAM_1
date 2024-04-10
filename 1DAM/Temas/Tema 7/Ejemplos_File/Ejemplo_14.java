package Ejemplos_File;

//SERIALIZACIÓN

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Ejemplo_14 {

    public static void main(String[] args) {

        // 1. Creamos una instancia de la clase Grupo
        // 2. Le agregamos dos alumnos
        Grupo dam = new Grupo("1DAM");
        dam.agregarAlumno(new Alumno("Pep", "1111A", 15));
        dam.agregarAlumno(new Alumno("Tom", "2222A", 17));

        //3. Hacemos un writeObject de esas instancia denominada dam

        try (FileOutputStream fos = new FileOutputStream("archivo.dat")) {
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(dam);
            out.writeInt(23);
            out.writeObject(new Alumno("Jon","3333A", 20));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}