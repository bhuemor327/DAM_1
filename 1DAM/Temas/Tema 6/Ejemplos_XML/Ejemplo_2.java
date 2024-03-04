// 3.2 TRANSFORMAR ÁRBOL DOM EN XML

package Ejemplos_XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import java.io.File;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.dom.DOMSource;

import javax.xml.parsers.ParserConfigurationException;
//import org.xml.sax.SAXException;
//import java.io.IOException;
import javax.xml.transform.TransformerException;


public class Ejemplo_2 {
	
	 public static void main(String[] args) {
		 try {
			 
		  // Crear un documento DOM XML
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            // Crear elementos para agregar al documento
            Element rootElement = doc.createElement("root");
            Element childElement = doc.createElement("child");
            childElement.setTextContent("Hello, World!");
            rootElement.appendChild(childElement);
            doc.appendChild(rootElement);
			 
			 
			// 1º Creamos una instancia de la clase File para acceder al archivo donde guardaremos el XML.
			File f =new File("C:\\Users\\Admin\\OneDrive\\Escritorio\\Antonio Gala\\DAM\\1DAM\\Temas\\prueba.xml");
			
			//2º Creamos una nueva instancia del transformador a través de la fábrica de transformadores.
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			//3º Establecemos algunas opciones de salida, como por ejemplo, la codificación de salida.
			transformer.setOutputProperty(OutputKeys.INDENT,"yes"); //indica que la salida debe ser indentada para una mejor legibilidad. 
			transformer.setOutputProperty(OutputKeys.ENCODING,"UTF-8");
			
			//4º Creamos el StreamResult, que intermediará entre el transformador y el archivo de destino.
			StreamResult result = new StreamResult(f);
			
			//5º Creamos el DOMSource, que intermediará entre el transformador y el árbol DOM.
			DOMSource source = new DOMSource(doc);
			
			//6º Realizamos la transformación.
			transformer.transform(source, result);
			
			} catch (ParserConfigurationException | TransformerException ex) {
	            System.out.println("¡Error! No se ha podido llevar a cabo la transformación.");
	            ex.printStackTrace();
			}
	 }

}
