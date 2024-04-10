package Interfaces_graficas;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Ejemplo_13 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // creamos contenedor con un rectángulo dentro
        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);
        Rectangle rectangulo = new Rectangle(100, 50, Color.GOLD);
        root.getChildren().addAll(rectangulo);
        Scene scene = new Scene(root, 400, 400);

        // ContextMenu para el botón derecho del ratón
        ContextMenu contextMenu = new ContextMenu();
        MenuItem menuItem1 = new MenuItem("Rectángulo Azul");
        MenuItem menuItem2 = new MenuItem("Rectángulo Verde");
        contextMenu.getItems().addAll(menuItem1, menuItem2);

        // establecemos manejadores de eventos para la captura y burbuja
        rectangulo.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            System.out.println("Evento en el rectángulo");
        });

       /*/ rectangulo.setOnMouseClicked(e -> {
            System.out.println("Evento en el rectángulo");
        });
        */
        root.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("Evento en el VBox: Has pulsado con el botón derecho");
            } else
                System.out.println("Evento en el VBox: Has pulsado con el izquierdo");
        });

        // evento filtrado clic derecho del ratón
        /*/ El método addEventFilter() en JavaFX permite agregar un filtro de eventos a un nodo.
            Un filtro de eventos es similar a un manejador de eventos, pero se ejecuta antes de que se procese el
            evento por cualquier manejador de eventos asociado al nodo o a sus hijos.
         */
        root.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                System.out.println("Mostrando menú contextual");
                contextMenu.show(root, e.getScreenX(), e.getScreenY());
            }
            else{ System.out.println("Clic izquierdo filtrado");}
            //e.consume();
            /*/e.consume(), indica  que has consumido el evento y que no deseas que se propague más allá de ese filtro
                de eventos, es decir, no se activarán otros manejadores de eventos asociados a ese evento en otros nodos.
             */

        });

        // acciones sobre las opciones del menú contextual
        menuItem1.setOnAction(e -> rectangulo.setFill(Color.DODGERBLUE));
        menuItem2.setOnAction(e -> rectangulo.setFill(Color.PALEGREEN));

        // configurar escena y ventana
        primaryStage.setTitle("Ejemplo de Manejo de Eventos de Teclado y Ratón");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}