package Interfaces_graficas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

// EJEMPLO UTILIZANDO CLASE PARENT

public class Ejemplo_06 extends Application {
    @Override
    public void start(Stage ventanaPrincipal) {
        //1. Creamos los tres botones
        Button btn1 = new Button("Insertar");
        Button btn2 = new Button("Eliminar");
        Button btn3 = new Button("Mostrar");

        //2. Contenedor de tipo HBox al que le incluimos los botones
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btn1, btn2, btn3);

        //3. Creamos una etiqueta
        Label etiqueta = new Label("Etiqueta dentro de un FlowPane");

        //4. Creamos un contenedor de tipo FlowPane al que le agregamos la etiqueta
        FlowPane flowPane = new FlowPane();
        flowPane.getChildren().add(etiqueta);

        //5. Creamos el layout principal (Vbox)
        //   - Le añadimos como hijo los contenedores anteriores: HBox y FlowPane
        //   - Como es de tipo VBox tendremos primero el primer contenedor y justo debajo el siguiente.
        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, flowPane);

        //6. Creamos la escena pasándole el contenedor principal
        Scene scene = new Scene(vbox, 300, 250);
        ventanaPrincipal.setScene(scene);
        ventanaPrincipal.show();
    }
    public static void main(String[] args) {
        launch();
    }
}