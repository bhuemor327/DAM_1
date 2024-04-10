package Interfaces_graficas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Interfaz que solicita un texto determinado y, al dar al botón saludar, genera una ventana emergente donde utiliza el texto previamente indicado

public class Ejemplo_02 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventanaPrincipal) {
    //1. CREAMOS TODOS LOS NODOS NECESARIOS:
        // - Caja de texto
        // - Botón
        TextField texto = new TextField();
        Button boton = new Button("Saludar");

        /*/Asociamos un evento al botón, invocando a setonACtion, de forma que cada vez que se haga click,
            se ejecuten las acciones entre llaves.
         - Creamos un String donde almacenaremos el contenido del Textfield, invocando al método getText() de esa clase
         - Para mostrar una ventana emergente, podemos utilizar la clase Alert que proporciona métodos para crear y personaliar cuadros de diálogo
            - Creamos la alerta con un constructor que recibe el tipo de alerta
         - A través de esta instancia invocamos a 3 métodos: setTitle, setContextText (Contenido), show();
         */
        boton.setOnAction(e -> { String nombre = texto.getText();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Saludo Personalizado");
            alerta.setContentText("Hola " + nombre);
            alerta.setHeaderText(null); //Permmite quitar la cabecera de "Mensaje" de la ventana emergente
            alerta.show();
        });

    /*/ Añadimos los componentes a la aplicación para ello, vamos primero a organizar y administrar el diseño de los nodos
        - Utilizamos VBox: clase en JavaFX que representa un contenedor que organiza sus nodos secundarios en una única columna vertical.
        - Creamos una instancia de la clase Vbox donde hay que pasarle el espaciado entre los nodos que queremos establecer
        - Invocamos a 3 métodos de la clase VBox
            - Alineación, para centrar los nodos
            - SetPadding, que requiere una instancia Insets, donde se deben indicar los márgenes
            - getChildren().addAll() para añadir al contenedor ambos componentes, tanto el texto como el botón.

     */
        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(texto, boton);

    //2. CREAMOS LA ESCENA AÑADIENDO LOS NODOS REQUERIDOS
        // incluyendo el contenedor vbox
        Scene scene = new Scene(vbox, 300, 150);

    //3. AÑADIMOS A LA VENTANA PRINCIPAL LA ESCENA REQUERIDA Y MOSTRAMOS
        ventanaPrincipal.setTitle("Saludos!");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
}

/*/Algunos de los tipos de alerta disponibles incluyen
Alert.AlertType.INFORMATION Alert.AlertType.WARNING, Alert.AlertType.ERROR y Alert.AlertType.CONFIRMATION.
 */