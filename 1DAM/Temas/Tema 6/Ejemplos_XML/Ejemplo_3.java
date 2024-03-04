// Leer elementos de un fichero

package Ejemplos_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.io.File;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;


public class Ejemplo_3 {
	
	 public static void main(String[] args) {
		 try {
		 
		// Creo una instancia de DocumentBuilderFactory
		 DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		 
		// Creo una instancia documentBuilder que nos permitirá analizar el XML
		 DocumentBuilder builder = factory.newDocumentBuilder();
		 
		// Con el objeto builder, podemos crear el objeto de la clase Document
		 Document documento = builder.parse(new File("Concesionario.xml"));
		 
		// Una vez tenemos el documento, vamos a recorrerlo, tomando los elementos coche
		// Mediante el método getElementsByTagName() se busca todos los elementos "coches" en el documento XML 
		// y los almacena en un NodeList llamado ListaCoche.
		 NodeList ListaCoches = documento.getElementsByTagName("coche");
		 
		// Al ser como una especie de array habrá que recorrerlo iterando sobre cada nodo de la lista ListaCoches para acceder a sus propiedades
		 for (int i=0; i< ListaCoches.getLength(); i++) {
			 Node nodo = ListaCoches.item(i); //Cogemos el nodo de la posición i
			 
			//Existen varios tipos de nodo, luego para asegurarnos que se trata de un elemento (etiqueta) utilizamos la constante ELEMENT_NODE
					if(nodo.getNodeType()== Node.ELEMENT_NODE) {
						//Creamos un elemento y lo casteamos (convertir un nodo a elemento) ya que sabemos que son etiquetas
						Element e = (Element) nodo;
						
						//  Obtenemos todos los nodos hijos del elemento e y los almacenamos en una lista NodeList llamada hijos y repetimos.
						NodeList hijos = e.getChildNodes();
						for (int j =0; j< hijos.getLength();j++) {
							Node hijo = hijos.item(j);
							if(hijo.getNodeType() == Node.ELEMENT_NODE) {
								Element eHijo = (Element) hijo;
								System.out.println("Propiedad: " + eHijo.getNodeName() + " Valor:" + eHijo.getTextContent() );
							}
							
						} System.out.println("");
						
					}
			 
		 }
		 } catch (ParserConfigurationException | SAXException | IOException ex) {
	            System.out.println("\"¡Error! No se ha podido cargar el documento XML.");
	        }
		 
	 }

}
