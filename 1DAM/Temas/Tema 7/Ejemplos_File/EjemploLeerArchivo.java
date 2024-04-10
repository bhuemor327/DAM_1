package Ejemplos_File;

import java.io.*;

public class EjemploLeerArchivo {
    public static void main(String[] args) {
        String filename = "Prueba";
        int wordCount = countWords(filename);
        System.out.println("El archivo " + filename + " tiene " + wordCount + " palabras");


    }

    public static int countWords(String filename) {
        int wordCount = 0;

        try (BufferedReader bR = new BufferedReader(new FileReader(filename))) {
            String line;
            while((line = bR.readLine())!= null){
                String [] words = line.split("\\s+");
                wordCount+= words.length;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCount;
    }

}