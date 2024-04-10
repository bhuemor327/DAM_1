package Flujos_red;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) {
        // Socket del servidor
        ServerSocket servidor = null;
        //Socket del cliente
        Socket sc = null;

        DataInputStream in;
        DataOutputStream out;

        //puerto de nuestro servidor
        final int PUERTO = 5000;

        try {
            //Creamos el socket del servidor, que lanza una excepción
            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor iniciado");

            //Buscamos que siempre esté atento ante peticiones
            while (true) {
                // Cuando se llama al método accept(), el programa se bloquea y espera hasta que
                // llegue una conexión entrante desde un cliente
                // Cuando el cliente se conecta, devuelve un objeto Socket (del cliente) que representa la conexión establecida con ese cliente.
                sc = servidor.accept();
                System.out.println("Cliente conectado");

                // Creamos un objeto DataInputStream y DataOuputStream a partir del socket
                // El servidor puede leer datos enviados por el cliente a través del InputStream del Socket,
                // y puede enviar datos al cliente a través del OutputStream del Socket.

                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());

                //Lee y escribe el mensaje que me envia
                String mensaje = in.readUTF();
                System.out.println(mensaje);

                //Le envio un mensaje
                out.writeUTF("¡Hola desde el servidor!");

                //Cierro el socket
                sc.close();
                System.out.println("Cliente desconectado");

            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}