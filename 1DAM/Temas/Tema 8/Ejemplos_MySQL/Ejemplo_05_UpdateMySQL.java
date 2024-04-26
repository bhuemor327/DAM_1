package Ejemplos_MySQL;

import java.sql.*;
import java.util.Random;

public class Ejemplo_05_UpdateMySQL {

    public static void main(String[] args) {

        try {
            //1. CREAR CONEXIÓN
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url,user,pwd);

            /*/
            String query = " UPDATE contacto SET nombre = 'maria2' WHERE nombre = 'maria'";
            Statement instruccion = conex.createStatement();
            int resultado = instruccion.executeUpdate(query);
            */

            // UTILIZANDO PARÁMETROS DE SUSTITUCIÓN
            String query = "UPDATE contacto SET nombre = ? WHERE nombre = ?";
            PreparedStatement queryInsert = conex.prepareStatement(query);
            queryInsert.setString(1, "maria2");
            queryInsert.setString(2, "maria");
            int resultado = queryInsert.executeUpdate();


            //4. ANALIZAMOS EL RESULTADO
            if (resultado == 1)
                System.out.println("Contacto actualizado correctamente");


        } catch (SQLException e) { System.out.println(e); }

    }
}