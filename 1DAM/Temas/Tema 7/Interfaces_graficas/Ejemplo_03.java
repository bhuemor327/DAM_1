package Interfaces_graficas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ejemplo_03 extends Application {
    @Override
    public void start(Stage stage) {
        Button boton = new Button("Pulsa"); // button es un Node
        boton.setTranslateX(50); // mover 50 píxeles a la derecha
        boton.setTranslateY(50); // mover 50 píxeles hacia abajo
        boton.setRotate(45); // rotar 45 grados
        boton.setScaleX(1.5); // escalar 1.5 veces en el eje X
        Scene scene = new Scene(boton, 500, 500);
        stage.setScene(scene);
        stage.show();
    }  public static void main(String[] args) {
        launch(args);
    }
}
