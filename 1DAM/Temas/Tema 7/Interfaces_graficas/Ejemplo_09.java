package Interfaces_graficas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.NumberBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.*;
import javafx.stage.Stage;

public class Ejemplo_09 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        IntegerProperty a = new SimpleIntegerProperty(5);
        IntegerProperty b = new SimpleIntegerProperty(2);

        // Ahora no haremos a.add.b para sumar, sino que utilizamos el método estático .add de la clase Bindings
        NumberBinding suma = Bindings.add(a, b);
        System.out.println("Suma: " + suma.getValue()); // Suma: 7

        /*/ Uso de método when. Creamos dos propieades
           - Propiedad 1: Tipo Booleana con valor true
           - Propiedad 2: Tipo String vacía
           - Vinculamos el valor de la string resultado a aquello que nos devuelva el metodo when de forma que:
                Si el valor de condición es true, en la string se guardará "Verdadero"
                Si el valor de condición es false, en la string se guardará "Falso"
         */
        BooleanProperty condicion = new SimpleBooleanProperty(true);
        StringProperty resultado = new SimpleStringProperty("");
        resultado.bind(Bindings.when(condicion).then("Verdadero").otherwise("Falso"));
        System.out.println("Resultado: " + resultado.getValue()); // Resultado: Verdadero

    }
}
