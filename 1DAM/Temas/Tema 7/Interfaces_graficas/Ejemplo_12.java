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

public class Ejemplo_12 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventanaPrincipal) {

        TextField texto = new TextField();
        Button boton = new Button("Saludar");


        boton.setOnAction(e -> { String nombre = texto.getText();
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Saludo Personalizado");
            alerta.setContentText("Hola " + nombre);
            //alerta.setHeaderText(null); //Permmite quitar la cabecera de "Mensaje" de la ventana emergente
            alerta.show();
        });


        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20, 20, 20, 20));
        vbox.getChildren().addAll(texto, boton);


        Scene scene = new Scene(vbox, 300, 150);
        scene.getStylesheets().add(getClass().getResource("/JavaFX_images/Estilo.css").toExternalForm());

        ventanaPrincipal.setTitle("Saludos!");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
}

