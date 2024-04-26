package Ejemplos_MySQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejemplo_06_DeleteMySQL {

    public static void main(String[] args) {

        try {

            // realizamos conexión
            String user = "root";
            String pwd = "";
            String url = "jdbc:MySQL://localhost/agenda";
            Connection conex = DriverManager.getConnection(url,user,pwd);

            // borramos contacto utilizando parámetros de sustitución
            String query = "DELETE FROM contacto WHERE nombre = ?";
            PreparedStatement queryDelete = conex.prepareStatement(query);
            queryDelete.setString (1, "juan");
            int resultado = queryDelete.executeUpdate();

            /*/ - Si quitamos el WHERE borrará todos los datos de la tabla
            queryDelete.setString (1, "") --> Borrará aquellos con el nombre vacío
            queryDelete.setInt (1, 25) --> Si tuvieramos alguna columna con valores enteros se debería utilizar setInt

             */
            // analizamos el resultado del insert
            if (resultado > 0)
                System.out.println("Se han borrado " + resultado + " contactos correctamente");


        } catch (SQLException e) {
            System.out.println(e);
        }


    }
}
