package Interfaces_graficas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// EJEMPLO UTILIZANDO CLASE PARENT

public class Ejemplo_05 extends Application {
    @Override
    public void start(Stage ventanaPrincipal) {

        Button boton1 = new Button("Botón 1");
        Button boton2 = new Button("Botón 2");

        //1. Movemos los botones
        boton1.setTranslateX(50);
        boton1.setTranslateY(50);

        boton2.setTranslateX(10);
        boton2.setTranslateY(50);

        //2. Desplazamos el vbox 100px hacia abajo (Se moverán también los botones)
        VBox vbox = new VBox();//Si como parámetro le pasamos un 10, separa los botones 10px
        vbox.getChildren().addAll(boton1, boton2);
        boton1.setRotate(45);
        vbox.setRotate(45);
        vbox.setTranslateY(100);

        Scene scene = new Scene(vbox, 500, 300); // La raíz de la escena es un Parent
        ventanaPrincipal.setTitle("Ejemplo de Parent");
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
    public static void main(String[] args) {
        launch();
    }
}