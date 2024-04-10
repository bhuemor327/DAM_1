package Interfaces_graficas;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.stage.Stage;

public class Ejemplo_08 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
// 1. ejemplos con String
        // - Creamos dos propiedades de string con valores Juan y Perz respectivamente
        StringProperty nombre = new SimpleStringProperty("Juan");
        StringProperty apellido = new SimpleStringProperty("Pérez");

        /*/ - Creamos una instancia de la clase StringBinding llamada nombreCompleto y le asignaremos el resultado
              de invocar al método .concat de la clase Binding, el cual nos permite concatenar varias propiedades.
            - Este concat devuelve un objeto de tipo StringExpression, que es una superclase de StringBinding
              y por tanto no lo podemos asignar directamente al StringBinding ya que esa expresión concat
              puede representar cualquier expresión de cadena, no necesariamente un StringBinding.
              Por ello, hay que indicar que la expresión devuelta será un StringBinding
        * */
        StringBinding nombreCompleto = (StringBinding) Bindings.concat(nombre, " ", apellido);
        System.out.println(nombreCompleto.get()); // Juan Pérez

        // - Hacemos un cambio a la propiedad nombre
        nombre.set("Ana");
        System.out.println(nombreCompleto.get()); // Ana Pérez


// 2. ejemplos con Boolean
        // - Creamos dos propieades
        BooleanProperty condicionA = new SimpleBooleanProperty(true);
        BooleanProperty condicionB = new SimpleBooleanProperty(false);

        // - Creamos una instancia de tipo BooleanBinding
        //   En este ejemplo usamos el método and. Este devuelve true cuando ambos son true y en caso contrario devuelve un false
        BooleanBinding ambasVerdaderas = condicionA.and(condicionB);
        System.out.println(ambasVerdaderas.get()); // false

        // Cambiamos el valor de condicionB
        condicionB.set(true);
        System.out.println(ambasVerdaderas.get()); // true

        // - Ahora generamos una instancia BooleanBinding pero con la condición or y not
        //   or: Devuelve true si alguna es true
        //   not: se almacena el valor de condicionA negado
        BooleanBinding cualquieraVerdadera = condicionA.or(condicionB);
        BooleanBinding noA = condicionA.not();
        System.out.println(cualquieraVerdadera.get()); // true
        System.out.println(noA.get()); // false

    }
}
