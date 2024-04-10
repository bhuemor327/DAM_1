package Ejemplos_File;


//Esta clase contiene información de un grupo de alumnos
//Es necesario indicar que los objetos que se van a guardar serán serializables, indicandolo en las cabeceras de las clases
//COmo grupo contiene objetos de tipo Alumno, es importante que si queremos serializar grupo, debemos serializar también Alumno

import java.io.Serializable;
import java.util.ArrayList;

public class Grupo implements Serializable {
    //private static final long serialVersionUID = -1855822552255525L;
    private String nombre;
    private ArrayList<Alumno> alumnos;

    public Grupo(String nombre) {
        this.nombre = nombre;
        alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Alumno> getAlumnos() {
        return alumnos;
    }

    public void agregarAlumno(Alumno a) {
        alumnos.add(a);
    }

    public void mostrarAlumnos() {
        for (Alumno a : alumnos) {
            System.out.println(a);
        }
    }

    @Override
    public String toString() {
        String s = "El nombre del Grupo es: " + getNombre() + "\n";
        for (Alumno alumno : alumnos) {
            s += alumno.toString() + "\n";
        }
        return s;
    }
}