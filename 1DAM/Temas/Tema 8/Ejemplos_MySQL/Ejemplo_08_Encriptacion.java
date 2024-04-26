package Ejemplos_MySQL;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejemplo_08_Encriptacion {

    public static void main(String[] args) {

        try {
            // realizamos conexión utilizando el método conectar definido en la clase ConexiónBD
            Connection conex = ConexionBD.conectar("usuarios");
            //insertarUsuario(conex, "tom3@tom.com", "tom3");
            verificarPwd(conex, "tom2@tom.com", "tom");

        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    // Método que permite insertar un usuario a través de los campos correo y pwd
    // Recibe como parámetros el correo, la contraseña y una instancia de la clase Conecction

    public static void insertarUsuario(Connection conex, String correo, String pwd) {

        try {

        // 1. encriptamos la contraseña
            // Utilizamos el método hashpw de la clase BCrypt para generar un hash de contraseña encrip
            // Recibe como parámetro la contraseña a encriptar y el método BCrypt.gensalt()
            // el método BCrypt.gensalt() genera un salt aleatorio que se añade a la contraseña antes de encriptarla.
            // El salt es un valor aleatorio único que se concatena con la contraseña antes de aplicar la función de hash. El uso de un salt aumenta la seguridad del hash y evita que los ataques de fuerza bruta sean eficaces
            String pwdEncriptada = BCrypt.hashpw(pwd, BCrypt.gensalt());

            // preparamos y ejecutamos insert
            String query = "INSERT INTO contacto VALUES (?,?)";
            PreparedStatement queryInsert = conex.prepareStatement(query);
            queryInsert.setString(1, correo);
            queryInsert.setString(2, pwdEncriptada);
            queryInsert.executeUpdate();
            System.out.println("El usuario con correo " + correo + " se ha insertado correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarPwd(Connection conex, String correo, String pwd) {
        try {
            // preparamos consulta SQL para obtener la contraseña encriptada que está almacenada en el registro con ese correo
            String query = "SELECT contraseña FROM contacto WHERE correo = ?";
            PreparedStatement querySelect = conex.prepareStatement(query);
            querySelect.setString(1, correo);
            ResultSet resultado = querySelect.executeQuery();

            if (resultado.next()) {
                //Accedemos al campo contraseña
                String pwdAlmacenada = resultado.getString("contraseña");

                // verificamos si la contraseña recibida coincide utilizando el método checkpw
                // Este metodo recibe la contraseña sin encriptar y a continuación , la encriptada
                // DEvuelve true si ambas son iguales y false en caso contrario
                if (BCrypt.checkpw(pwd, pwdAlmacenada)) {
                    System.out.println("La contraseña es válida");
                    return true;
                } else {
                    System.out.println("La contraseña no es válida");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("No existe ningún contacto con el correo " + correo);
        return false;
    }

}