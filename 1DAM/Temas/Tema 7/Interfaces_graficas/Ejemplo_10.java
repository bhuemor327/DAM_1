package Interfaces_graficas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.*;
import javafx.stage.Stage;

public class Ejemplo_10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        IntegerProperty num1 = new SimpleIntegerProperty(10);
        IntegerProperty num2 = new SimpleIntegerProperty(20);
        IntegerProperty valorCondicion = new SimpleIntegerProperty(50);

        NumberBinding multiplication = num1.multiply(num2);

        NumberBinding result = Bindings.when(multiplication.greaterThan(100))
                .then(multiplication.add(valorCondicion))
                .otherwise(multiplication);

        System.out.println("Resultado inicial: " + result.getValue());

        num1.set(5);
        System.out.println("Después de cambiar num1: " + result.getValue());

        num2.set(25);
        System.out.println("Después de cambiar num2: " + result.getValue());

        valorCondicion.set(100);
        System.out.println("Después de cambiar valorCondicion: " + result.getValue());

    }
}
