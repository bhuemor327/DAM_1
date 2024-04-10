package Interfaces_graficas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// EJEMPLO UTILIZANDO CLASE PARENT

public class Ejemplo_04 extends Application {
    @Override
    public void start(Stage ventanaPrincipal) {
        // 1. Generamos dos botones
        Button boton1 = new Button("Botón 1");
        Button boton2 = new Button("Botón 2");

        //2. Creamos un VBox que es una subclase de Parent y le añadimos ambos botones
        VBox vbox = new VBox();
        vbox.getChildren().addAll(boton1, boton2);

        //3. Aplicamos una rotación de 45 al boton1 y otra al VBox
       boton1.setRotate(45);
        vbox.setRotate(45);

        //4. Creamos la escena pasandole la instancia de la clase VBox
        // - Añadimos titulo
        Scene scene = new Scene(vbox, 50, 30); // La raíz de la escena es un Parent
        ventanaPrincipal.setTitle("Ejemplo de Parent");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
    public static void main(String[] args) {
        launch();
    }
}