package Ejemplos_regex;

//Búsqueda de palabras de una frase con exactamente 3 letras

import java.util.regex.*;

public class Ejemplo_3 {
  public static void main(String[] args) {
      String[] textos = {
          "Mi nombre es Belen y trabajo en Palma del Rio",
          "He comprado una casa nueva en el centro de la ciudad",
          "El gato es negro y blanco y viene a comer cada dia"
      };

      // Patrón a buscar
      Pattern patron = Pattern.compile("\\b\\w{3}\\b"); // Busca palabras de exactamente 3 letras

      // Iterar sobre cada cadena de texto
      for (String texto : textos) {
          System.out.println("Coincidencias parciales en el texto: \"" + texto + "\":");
          Matcher matcher = patron.matcher(texto);

          // Buscar coincidencias
          while (matcher.find()) {
              System.out.println("Coincidencia encontrada: " + matcher.group()); //.group() devuelve la subcadena que coincidió con el patrón de búsqueda
          }
          System.out.println(); // Salto de línea entre textos
      }
  }
}
