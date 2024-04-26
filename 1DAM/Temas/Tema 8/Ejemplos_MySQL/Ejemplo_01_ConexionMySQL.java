package Ejemplos_MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejemplo_01_ConexionMySQL {

    // Datos conexión con la BD
    public static void main(String[] args) throws SQLException {

        try {

            String USER = "root";
            String PWD = "";
            String URL = "jdbc:MySQL://localhost/agenda";

            //Class.forName("com.mysql.cj.jdbc.Driver");
            // realizamos connexión
            Connection conex = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Se ha conectado correctamente");
            conex.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}