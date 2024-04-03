package Ejemplos_File;

import java.io.File;

//Crear, borrar y listar ficheros

public class Ejemplo_03 {

    public static void main(String[] args) {       
        String rutaCarpeta = ".";
        listarArchivos(new File (rutaCarpeta));
    }
    
    	public static void listarArchivos(File carpeta) {
    	
        
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
             
            for (File f : archivos) {
                if (f.isFile()) {
                	System.out.println(f.getName());
                } else if (f.isDirectory()) {
                	System.out.println(f.getPath());
                	listarArchivos(f);
                }
            
            }          
         } else System.out.println("La ruta proporcionada no es una carpeta");
        } 
    	
    	

    }  



