package Ejemplos_File;

import java.io.File;
import java.io.IOException;

//Crear, borrar y listar ficheros

public class Ejemplo_02 {

    public static void main(String[] args) {

        // 1. Creamos un archivo
    	/*/ - Creamos una intancia de la clase File haciendo referencia a un archivo dentro de la carpeta donde se está ejecutando el programa
    		- En el if, utilizamos el método createNewFile() sobre la instancia creada anteriormente, de forma que, si el archivo no existe devuelve 
    			un true y lo crea y en caso contrario devuelve un false.
    		- Si hubiera algún problema, por ejemplo, la falta de permisos para crear archivos, se lanzaría una excepción y a través del printStackTrace()
    			nos mostraría la secuenci ade errores.
    	/*/
    	 
        File archivo = new File("ejemplo2.txt");
        try {
            if (archivo.createNewFile())
                System.out.println("Archivo creado");
            else
                System.out.println("El archivo ya existe");
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        /*/ 2. Hacemos lo mismo para crear una  carpeta
         	  - La diferencia es que utilizamos el metodo mkdir() que no lanza ninguna excepción
        	  - Si el directorio no existe devuelve un true y lo crea, en caso contrario un false
        /*/
        File directorio = new File("Ejempo2_nuevoDirectorio");
        
        if (directorio.mkdir())
            System.out.println("Directorio creado");
        else
            System.out.println("No se pudo crear el directorio");

        // 3. Mismo procedimiento para borrar archivo/Directorio
        File archivoBorrar = new File("Ejempo2_nuevoDirectorio");
        if (archivoBorrar.delete())
            System.out.println("Directorio eliminado");
        else
            System.out.println("No se pudo eliminar el directorio");

        /*/ 4. Listamos una carpeta
         * - Creamos una instancia de la clase file haciendo referencia a la carpeta actual
         * - A partir de esa instancia invocamos al metodo list que devuelve un array de string con 
         * 		el nombre de los archivos dentro de la carpeta. Si no hay ningún archivo, almacenará un null
         * - Hacemos un if donde si hay algun archivo los mostrará mediante un flujo.
         */
        File directorio2 = new File("."); //Referencia a la carpeta actual
        String[] archivos = directorio2.list(); //Devuelve un array de string 
        System.out.println("\nLista de archivos:");
        if (archivos != null)
            for (String a : archivos)
                System.out.println(a);
        else
            System.out.println("No hay archivos en la carpeta");
    
       
       //OTRA FORMA DE LISTAR FICHEROS.
        
        String rutaCarpeta = ".";
        listarArchivos(rutaCarpeta);
    }
    
    	public static void listarArchivos(String rutaCarpeta) {
    	
    	File carpeta = new File(rutaCarpeta);
        
        if (carpeta.isDirectory()) {
            File[] archivos = carpeta.listFiles();
             //Listamos solo los archivos
            for (File f : archivos) {
                if (f.isFile()) {
                	System.out.println(f.getName() + "-" + f.length() + "bytes");
                }
            
            }          
         } else System.out.println("La ruta proporcionada no es una carpeta");
        } 
    	
    	

    }  



