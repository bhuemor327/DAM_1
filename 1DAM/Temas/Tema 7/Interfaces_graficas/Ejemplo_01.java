package Interfaces_graficas;

import javafx.application.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;

import java.awt.*;


public class Ejemplo_01 extends Application {
    public void start(Stage ventanaPrincipal){
    //1. CREAMOS TODOS LOS NODOS NECESARIOS
        //Creamos una instancia de la clase Button para crear botones
        Button boton = new Button("saludar");
        //Añadimos una acción a ese botón que será simplemente imprimir Hola mundo
        boton.setOnAction(e -> System.out.println("Hola mundo desde JavaFX") );

    //2. CREAMOS LA ESCENA AÑADIENDO LOS NODOS REQUERIDOS
        //Creamos una escena, indicando un componente de esa escena así como las dimensiones
        Scene escena = new Scene(boton, 200,100);

    //3. AÑADIMOS A LA VENTANA PRINCIPAL LA ESCENA REQUERIDA Y MOSTRAMOS
        //Sobre la ventana principal, invocamos una serie de métodos
        // - setScene: Nos permite establecer una escena en esa ventana principal
        // - setTitle: Ponemos titulo
        // - show(): Mostramos la escena
        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.setTitle("HolaMundoFX");
        ventanaPrincipal.show();

    }
    //Invocamos al método launch (de la case Application)
    //Inicializa al entorno de JavaFX y llama al método start
    //Como puede aceptar argumentos, se le suele poner como parámetros el arrray de string args, pero podemos no ponerlo
    public static void main (String[] args){
        launch(args);
    }
}