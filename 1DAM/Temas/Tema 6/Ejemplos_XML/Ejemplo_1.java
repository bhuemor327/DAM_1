// Cargar un documento XML

package Ejemplos_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;


public class Ejemplo_1 {
	
	 public static void main(String[] args) {
		 try {
		 
		// Creo una instancia de DocumentBuilderFactory
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
		 // Creo una instancia documentBuilder que nos permitirá analizar el XML
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 
		// Con el objeto builder, podemos crear el objeto de la clase Document
		 Document documento = builder.parse(new File("Concesionario.xml"));
		 
		 } catch (ParserConfigurationException | SAXException | IOException ex) {
	            System.out.println("\"¡Error! No se ha podido cargar el documento XML.");
	        }
		 
	 }

}
