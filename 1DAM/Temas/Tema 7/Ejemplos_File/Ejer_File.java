package Ejemplos_File;
import java.io.File;
import java.io.IOException;

public class Ejer_File {
    public static void main(String[] args) {
        String ruta = ".";

        ListadoArchivo(new File(ruta));
    }
    public static void ListadoArchivo(File carpeta1){
    if(carpeta1.isDirectory()){
        File[] lista=carpeta1.listFiles();
        for(File f:lista){
            if (f.isFile()){
                System.out.println("El nombre del fichero "+ f.getName());
            }else if(f.isDirectory()){
                ListadoArchivo (f);
            }
        }
    }
    }
}



