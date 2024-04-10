package Ejemplos_File;


import java.io.Serializable;

//Esta clase contiene información de un alumno (nombre, nia y edad)
//Es necesario indicar que los objetos que se van a guardar serán serializables, indicandolo en las cabeceras de las clases
public class Alumno implements Serializable {
    //private static final long serialVersionUID = -1855822552255525L;
    private String nombre;
    private String nia;
    private int edad;

    public Alumno(String nombre, String nia, int edad) {
        this.nombre = nombre;
        this.nia = nia;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNia() {
        return nia;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + nombre + ", nia=" + nia + ", edad=" + edad + "]";
    }
}