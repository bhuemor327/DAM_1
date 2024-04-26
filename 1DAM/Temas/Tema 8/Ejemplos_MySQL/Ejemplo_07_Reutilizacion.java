package Ejemplos_MySQL;

import java.sql.*;

public class Ejemplo_07_Reutilizacion {
    public static void main(String[] args) {
        try {
            //1. CREAR CONEXIÓN
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url, user, pwd);

            //2. CREAR OBJETO STATEMENT
            String query = "SELECT nombre, correo FROM contacto WHERE nombre=? AND correo=?";
            PreparedStatement consulta = conex.prepareStatement(query);
            consulta.setString(1, "maria2");
            consulta.setString(2, "maria@gmail.com");
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                System.out.println("NOMBRE: " + nombre);
                System.out.println("CORREO: " + correo);
            }

            //REUTILIZACIÓN DE CONSULTAS
            System.out.println("Ejecución de una segunda consulta");
            consulta.setString (1, "juan");
            consulta.setString (2, "juan@gmail.com");
            resultado = consulta.executeQuery();

            while (resultado.next()) {

                System.out.println("NOMBRE: " + resultado.getString(1) + "\nCORREO" + resultado.getString(2));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


}
