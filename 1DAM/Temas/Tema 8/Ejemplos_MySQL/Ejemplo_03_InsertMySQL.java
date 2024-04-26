package Ejemplos_MySQL;

import java.sql.*;
import java.util.Random;

public class Ejemplo_03_InsertMySQL {

    public static void main(String[] args) {

        try {
            //1. CREAR CONEXIÓN
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url,user,pwd);

            //2. CREAR OBJETO STATEMENT
            String query = "INSERT INTO contacto VALUES ('pepe', 'pepe@pepe.com')";
            Statement instruccion = conex.createStatement();

            //3.EJECUTAR SQL
            int resultado = instruccion.executeUpdate(query);

            //4. ANALIZAMOS EL RESULTADO
            if (resultado == 1)
                System.out.println("Contacto insertado correctamente");


        } catch (SQLException e) { System.out.println(e); }

    }
}