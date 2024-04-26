package Ejemplos_MySQL;
import java.sql.*;

public class Ejemplo_02_ConsultaMySQL {

    public static void main(String[] args) {
        try {
            //1. CREAR CONEXIÓN
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url, user, pwd);

            //2. CREAR OBJETO STATEMENT
            String query = "SELECT nombre, correo FROM contacto WHERE nombre LIKE 'j%'";
            Statement instruccion = (Statement) conex.createStatement();

            //3.EJECUTAR SQL
            ResultSet resultado = instruccion.executeQuery(query);

            //4. RESCORRER EL RESULTSET
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                System.out.println("NOMBRE: " + nombre);
                System.out.println("CORREO: " + correo);

            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
