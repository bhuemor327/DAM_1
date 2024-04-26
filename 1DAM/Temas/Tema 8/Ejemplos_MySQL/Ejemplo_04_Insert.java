package Ejemplos_MySQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class Ejemplo_04_Insert {

    public static void main(String[] args) {

        try {

            // Datos del contacto a insertar
            String nombre = GeneradorNombres.generarConApellido();
            String correo = nombre.replaceAll(" ", "_").toLowerCase() + "@gmail.com";
            //int edad = new Random().nextInt(18,25);

            // realizamos conexión
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url,user,pwd);

            /*/ insertamos contacto. La consulta utiliza parámetros de sustitución (?) para indicar los valores
            que se insertarán. Esto significa que los valores reales que se insertarán se especificarán
            más adelante en el código utilizando el método setString().
             */
            String query = "INSERT INTO contacto VALUES (?,?)";
            PreparedStatement queryInsert = conex.prepareStatement(query);
            queryInsert.setString(1, nombre);
            queryInsert.setString(2, correo);
            int resultado = queryInsert.executeUpdate();

            // analizamos el resultado del insert
            if (resultado == 1)
                System.out.println("El Contacto de nombre " + nombre + " se ha insertado correctamente con el correo " + correo);

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}