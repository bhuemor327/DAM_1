package Ejemplos_File;

//  como escribirtodo tipo de variables de tipo primitivo sobre un fichero binario
// y, más tarde, como leer esos datos que acabamos de escribir
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Ejemplo_12 {

    public static void main(String[] args) {
    	//1. Creamos 4 variables de tipos distintos
    	//   Cada uno de ellos necesita una cantidad distinta de bytes para ser almacenado en el fichero binario
        String fichero = "ejemplo.dat";
        boolean aprobado = false;
        String nombreAlumno = "Pepe";
        int conv = Integer.MAX_VALUE;
        float nota = 7.8f;
       
        
        try {
            //2. escribimos datos en el fichero binario
        	//   2.1 Creamos un new FileOuputStream que escribirá datos en un fichero binario
        	//   2.2 Lo envolvemos en un DataOuputStream que permitirá usar los distintos métodos para escribir.
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
            out.writeBoolean(aprobado);
            out.writeUTF(nombreAlumno);
            out.writeInt(conv);
            out.writeFloat(nota);
            out.close();

            //3. leemos datos del fichero binario
            //   3.1 Es importante que se lean en el mismo orden en el que han sido escritos
            DataInputStream in = new DataInputStream(new FileInputStream(fichero));
            System.out.println("Valor leído de aprobado: " + in.readBoolean());
            System.out.println("Valor leído de nombreAlumno: " + in.readUTF());
            System.out.println("Valor leído de convocatoria: " + in.readInt());
            System.out.println("Valor leído de nota: " + in.readFloat());
            in.close();

        } catch (IOException e) {
            System.out.println("ERROR");
        }

    }
}